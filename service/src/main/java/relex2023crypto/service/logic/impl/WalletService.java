package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.WalletRepository;
import relex2023crypto.service.logic.IWalletService;
import relex2023crypto.service.mapper.IWalletMapper;
import relex2023crypto.service.model.ResponseDto;
import relex2023crypto.service.model.WalletDto;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService implements IWalletService {
    private static final Logger logger = LoggerFactory.getLogger(WalletService.class);
    private final WalletRepository rep;
    private final IWalletMapper map;

    @Autowired
    public WalletService(WalletRepository rep, IWalletMapper map) {
        this.rep = rep;
        this.map = map;
    }

    @Override
    public WalletDto getWalletById(Integer requestingUserId, Integer walletId) {
        logger.info("Requested wallet {} info by user {}, access: {}",
                walletId, requestingUserId, "access");
        return rep.findById(walletId)
                .map(map::fromEntity)
                .orElseThrow();
    }

    @Override
    public ResponseDto deleteWalletById(Integer requestingUserId, Integer walletID) {
        logger.info("Deleting wallet {} was requested by user {}, access: {}",
                walletID, requestingUserId, "access");
        rep.deleteById(walletID);
        return new ResponseDto("Wallet {} was successfully deleted", walletID);
    }

    @Override
    public ResponseDto createWallet(WalletDto dto) {
        logger.info("Requested creation of wallet {} in currency {} by user {}",
                dto.getId(), dto.getCurrencyId(), dto.getUserId());
        rep.save(map.toEntity(dto));
        return new ResponseDto("Wallet {} in currency {} by user {} was created successfully",
                dto.getId(), dto.getCurrencyId(), dto.getUserId());
    }

    @Override
    public List<WalletDto> getUserWallets(Integer userId) {
        //todo: also add verification
        logger.info("Requested all user {} wallets by user {}, access: {}",
                userId, "userId", "access");
        return Optional.of(rep.findAll())
                .map(map::fromEntities)
                .orElseThrow();
    }

    @Override
    public List<WalletDto> getAll(Integer requestingUserId) {
        logger.info("Requested all wallets info by user {}, access: {}",
                requestingUserId, "access");
        return Optional.of(rep.findAll())
                .map(map::fromEntities)
                .orElseThrow();
    }
}
