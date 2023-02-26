package relex2023crypto.service.logic.impl;

import org.springframework.stereotype.Service;
import relex2023crypto.service.logic.ICurrencyService;
import relex2023crypto.service.model.CurrencyDto;

import java.util.List;

@Service
public class CurrencyService implements ICurrencyService {
    @Override
    public List<CurrencyDto> getAll() {
        return null;
    }

    @Override
    public CurrencyDto createCurrency(Integer requestingUserId, CurrencyDto dto) {
        return null;
    }

    @Override
    public CurrencyDto deleteCurrencyById(Integer requestingUserId, Integer currencyId) {
        return null;
    }
}
