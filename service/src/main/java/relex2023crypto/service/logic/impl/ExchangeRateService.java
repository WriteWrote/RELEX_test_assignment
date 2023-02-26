package relex2023crypto.service.logic.impl;

import org.springframework.stereotype.Service;
import relex2023crypto.service.logic.IExchangeRateService;
import relex2023crypto.service.model.ExchangeRateDto;

import java.util.List;

@Service
public class ExchangeRateService implements IExchangeRateService {
    @Override
    public ExchangeRateDto getExchangeRateById(Integer first, Integer second) {
        return null;
    }

    @Override
    public List<ExchangeRateDto> getAll() {
        return null;
    }

    @Override
    public ExchangeRateDto modifyExchangeRateById(Integer requestingUserId, ExchangeRateDto dto) {
        return null;
    }
}
