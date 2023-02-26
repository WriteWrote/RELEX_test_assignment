package relex2023crypto.service.logic.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.CurrencyRepository;
import relex2023crypto.service.logic.ICurrencyService;
import relex2023crypto.service.mapper.ICurrencyMapper;
import relex2023crypto.service.model.CurrencyDto;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService implements ICurrencyService {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyService.class);
    private final CurrencyRepository rep;
    private final ICurrencyMapper map;

    @Autowired
    public CurrencyService(CurrencyRepository rep, ICurrencyMapper map) {
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
    public CurrencyDto createCurrency(Integer requestingUserId, CurrencyDto dto) {
//        todo: create an Admin repo and add checkin the requesting user id is in the table of admins
        logger.info("Requested creating a new currency by user {}, access: {}",
                requestingUserId, "access");

        return Optional.of(dto)
                .map(map::toEntity)
                .map(rep::save)
                .map(map::fromEntity)
                .orElseThrow();
    }

    @Override
    public void deleteCurrencyById(Integer requestingUserId, Integer currencyId) {

        logger.info("Requested deleting currency (id: {}, name: {}) by user {}, access: {}",
                currencyId, "name", requestingUserId, "access");
        rep.deleteById(currencyId);
    }
}
