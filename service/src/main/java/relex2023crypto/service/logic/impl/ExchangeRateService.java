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

import relex2023crypto.service.model.requests.ExchangeRateDto;
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
        return Optional.of(rep.findByCurrencyFromAndCurrencyTo(first, second))
                .map(map::fromEntity)
                .orElseThrow();
    }

    @Override
    public ResponseDto<ExchangeRateDto> createExchangeRate(ExchangeRateDto dto) {
        Boolean access = provider.checkAdminAccessByUserSecretKey(dto.getRequestingSecretKey());
        logger.info("Requested creating new exchange rate by secret key {}, access: {}",
                dto.getRequestingSecretKey(), access);
        if (!access) {
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins", false);
        }

        ExchangeRateEntity entity = map.toEntity(dto);
        rep.save(entity);
        return new ResponseDto<>("Operation succeeded", true);
    }

    @Override
    public ResponseDto<Integer> deleteExchangeRate(Integer requestingUser, Integer rateId) {
        Boolean access = provider.checkAdminAccessByUserId(requestingUser);
        logger.info("Requested creating new exchange rate by user {}, access: {}",
                requestingUser, access);
        if (!access) {
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins", false);
        }
        rep.deleteById(rateId);
        return new ResponseDto<>("Operation succeeded", true);
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
        Boolean access = provider.checkAdminAccessByUserSecretKey(dto.getRequestingSecretKey());

        logger.info("Requested modifying the currency exchange rate ({} - {}) by secret key: {}, access: {}",
                dto.getCurrencyFrom(), dto.getCurrencyTo(), dto.getRequestingSecretKey(), access);
        if (!access) {
            return new ResponseDto<>("Operation denied  due to access restriction." +
                    "This operation is only available for admins", false);
        }

        ExchangeRateEntity newEntity = map.merge(dto, rep.findByCurrencyFromAndCurrencyTo(dto.getCurrencyFrom(),
                dto.getCurrencyTo()));

        return new ResponseDto<>("Operation succeeded", true,
                Optional.of(rep.save(newEntity))
                        .map(map::fromEntity)
                        .orElseThrow());
    }
}
