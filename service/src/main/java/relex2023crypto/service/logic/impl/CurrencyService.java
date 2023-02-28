package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.CurrencyRepository;
import relex2023crypto.service.logic.ICurrencyService;
import relex2023crypto.service.logic.utils.AccessProvider;
import relex2023crypto.service.mapper.ICurrencyMapper;
import relex2023crypto.service.model.CurrencyDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService implements ICurrencyService {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyService.class);
    private final AccessProvider provider;
    private final CurrencyRepository rep;
    private final ICurrencyMapper map;

    @Autowired
    public CurrencyService(AccessProvider provider, CurrencyRepository rep, ICurrencyMapper map) {
        this.provider = provider;
        this.rep = rep;
        this.map = map;
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
        Boolean access = provider.checkAccessByUserId(requestingUserId);
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
        Boolean access = provider.checkAccessByUserId(requestingUserId);
        logger.info("Requested deleting currency {} by user {}, access: {}",
                currencyId, requestingUserId, access);
        if (!access)
            return new ResponseDto<>("Operation denied");

        rep.deleteById(currencyId);

        return new ResponseDto<Integer>("Currency {} was successfully deleted", currencyId);
    }
}
