package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.entities.WalletEntity;
import relex2023crypto.db.repositories.CurrencyRepository;
import relex2023crypto.db.repositories.WalletRepository;
import relex2023crypto.service.logic.ICurrencyService;
import relex2023crypto.service.logic.utils.AdminAccessProvider;
import relex2023crypto.service.mapper.ICurrencyMapper;
import relex2023crypto.service.model.CurrencyDto;
import relex2023crypto.service.model.responses.CurrencySumDto;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.SecretKeyDto;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService implements ICurrencyService {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyService.class);
    private final AdminAccessProvider provider;
    private final CurrencyRepository rep;
    private final ICurrencyMapper map;

    private final WalletRepository walletRepository;

    @Autowired
    public CurrencyService(AdminAccessProvider provider, CurrencyRepository rep, ICurrencyMapper map, WalletRepository walletRepository) {
        this.provider = provider;
        this.rep = rep;
        this.map = map;
        this.walletRepository = walletRepository;
    }

    @Override
    public List<CurrencyDto> getAll() {
        logger.info("Requested list of all currencies");
        return Optional.of(rep.findAll())
                .map(map::fromEntities)
                .orElseThrow();
    }

    @Override
    public ResponseDto<CurrencyDto> createCurrency(Integer requestingUserId, CurrencyDto dto) {
        Boolean access = provider.checkAdminAccessByUserId(requestingUserId);
        logger.info("Requested creating a new currency by user {}, access: {}",
                requestingUserId, access);

        if (!access)
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins");

        return new ResponseDto<>("Operation succeeded",
                Optional.of(dto)
                        .map(map::toEntity)
                        .map(rep::save)
                        .map(map::fromEntity)
                        .orElseThrow());
    }

    @Override
    public ResponseDto<Integer> deleteCurrencyById(Integer requestingUserId, Integer currencyId) {
        Boolean access = provider.checkAdminAccessByUserId(requestingUserId);
        logger.info("Requested deleting currency {} by user {}, access: {}",
                currencyId, requestingUserId, access);
        if (!access)
            return new ResponseDto<>("Operation denied");

        rep.deleteById(currencyId);

        return new ResponseDto<Integer>("Currency {} was successfully deleted", currencyId);
    }

    @Override
    public ResponseDto<CurrencySumDto> checkCurrencySum(Integer currencyId, SecretKeyDto dto) {
        boolean access = provider.checkAdminAccessByUserSecretKey(dto.getSecretKey());

        logger.info("Requested currency sum by secret key {}, access: {}",
                dto.getSecretKey(), access);

        if (!access) {
            return new ResponseDto<>("Operation denied due to access restriction." +
                    "This operation is only available for admins");
        }

        List<WalletEntity> wallets = walletRepository.findAllByCurrencyId(currencyId);
        Double sum = 0.0;

        for (WalletEntity w : wallets) {
            sum += w.getCurrencySum();
        }

        CurrencySumDto responseArg = new CurrencySumDto(rep.getById(currencyId).getCurrencyName(), sum);

        return new ResponseDto<>("Operation succeeded", responseArg);
    }
}
