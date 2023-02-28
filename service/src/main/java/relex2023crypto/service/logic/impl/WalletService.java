package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.entities.WalletEntity;
import relex2023crypto.db.repositories.WalletRepository;
import relex2023crypto.service.logic.IWalletService;
import relex2023crypto.service.logic.utils.AccessProvider;
import relex2023crypto.service.mapper.IWalletMapper;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.WalletDto;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WalletService implements IWalletService {
    private static final Logger logger = LoggerFactory.getLogger(WalletService.class);
    private final AccessProvider provider;
    private final WalletRepository rep;
    private final IWalletMapper map;

    @Autowired
    public WalletService(AccessProvider provider, WalletRepository rep, IWalletMapper map) {
        this.provider = provider;
        this.rep = rep;
        this.map = map;
    }

    private Boolean checkAccess(Integer id, WalletEntity wallet) {
        Boolean adminAccess = provider.checkAccessByUserId(id);
        Boolean isUserRequesting = Objects.equals(wallet.getUser().getId(), id);
        return adminAccess || isUserRequesting;
    }

    @Override
    public ResponseDto<WalletDto> getWalletById(Integer requestingUserId, Integer walletId) {
        Boolean access = checkAccess(requestingUserId, rep.getById(walletId));
        logger.info("Requested wallet {} info by user {}, access: {}",
                walletId, requestingUserId, access);
        if (!(access)) {
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins or user owning the wallet");
        }
        return new ResponseDto<>("Operation succeeded",
                rep.findById(walletId)
                        .map(map::fromEntity)
                        .orElseThrow());
    }

    @Override
    public ResponseDto<Integer> deleteWalletById(Integer requestingUserId, Integer walletID) {
        Boolean access = checkAccess(requestingUserId, rep.getById(walletID));
        logger.info("Deleting wallet {} was requested by user {}, access: {}",
                walletID, requestingUserId, access);
        if (!access)
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins or user owning wallet {}", walletID);
        rep.deleteById(walletID);
        return new ResponseDto<Integer>("Wallet {} was successfully deleted", walletID);
    }

    @Override
    public ResponseDto<Integer> createWallet(WalletDto dto) {
        logger.info("Requested creation of wallet {} in currency {} by user {}",
                dto.getId(), dto.getCurrencyId(), dto.getUserId());
        rep.save(map.toEntity(dto));
        return new ResponseDto<Integer>("Wallet {} in currency {} by user {} was created successfully",
                dto.getId(), dto.getCurrencyId(), dto.getUserId());
    }

    @Override
    public ResponseDto<List<WalletDto>> getUserWallets(Integer requestingUserId,
                                                       Integer userId) {
        Boolean access = provider.checkAccessByUserId(requestingUserId);
        logger.info("Requested all user {} wallets by user {}, access: {}",
                userId, "userId", access);
        if (!access) {
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins or user who ows his wallets");
        }
        return new ResponseDto<>("Operation succeeded",
                Optional.of(rep.findAll())
                        .map(map::fromEntities)
                        .orElseThrow());
    }

    @Override
    public ResponseDto<List<WalletDto>> getAll(Integer requestingUserId) {
        Boolean access = checkAccess(requestingUserId, rep.findAllByUserId(requestingUserId).get(0));
        logger.info("Requested all wallets info by user {}, access: {}",
                requestingUserId, "access");
        if (!access) {
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins");
        }
        return new ResponseDto<>("Operation succeeded",
                Optional.of(rep.findAll())
                        .map(map::fromEntities)
                        .orElseThrow());
    }
}
