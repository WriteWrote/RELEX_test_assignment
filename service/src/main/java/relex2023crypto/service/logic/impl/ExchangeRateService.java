package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.entities.ExchangeRateEntity;
import relex2023crypto.db.repositories.ExchangeRateRepository;
import relex2023crypto.service.logic.IExchangeRateService;
import relex2023crypto.service.logic.utils.AdminAccessProvider;
import relex2023crypto.service.mapper.IExchangeRateMapper;
import relex2023crypto.service.model.ExchangeRateDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRateService implements IExchangeRateService {
    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateService.class);
    private final AdminAccessProvider provider;
    private final ExchangeRateRepository rep;
    private final IExchangeRateMapper map;

    @Autowired
    public ExchangeRateService(AdminAccessProvider provider, ExchangeRateRepository rep, IExchangeRateMapper map) {
        this.provider = provider;
        this.rep = rep;
        this.map = map;
    }

    @Override
    public ExchangeRateDto getExchangeRateById(Integer first, Integer second) {
        logger.info("Requested exchange rate for currencies: {} - {}",
                first, second);
        return Optional.of(rep.findByCurrency1AndCurrency2(first, second))
                .map(map::fromEntity)
                .orElseThrow();
    }

    @Override
    public List<ExchangeRateDto> getAll() {
        logger.info("Requested all exchange rates");
        return Optional.of(rep.findAll())
                .map(map::fromEntities)
                .orElseThrow();
    }

    @Override
    public ResponseDto<ExchangeRateDto> modifyExchangeRateById(ExchangeRateDto dto) {
//        Boolean access = provider.checkAdminAccessByUserId(requestingUserId);
        Boolean access = provider.checkAdminAccessByUserSecretKey(dto.getRequestingSecretKey());

        logger.info("Requested modifying the currency exchange rate ({} - {}) by secret key: {}, access: {}",
                dto.getCurrency_id1(), dto.getCurrency_id2(), dto.getRequestingSecretKey(), access);
        if (!access) {
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins");
        }

        ExchangeRateEntity newEntity = map.merge(dto, rep.findByCurrency1AndCurrency2(dto.getCurrency_id1(),
                dto.getCurrency_id2()));

        return new ResponseDto<>("Operation succeeded",
                Optional.of(rep.save(newEntity))
                .map(map::fromEntity)
                .orElseThrow());
    }
}
