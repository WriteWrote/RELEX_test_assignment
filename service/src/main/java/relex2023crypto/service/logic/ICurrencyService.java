package relex2023crypto.service.logic;

import org.springframework.validation.annotation.Validated;
import relex2023crypto.service.model.CurrencyDto;

import java.util.List;

public interface ICurrencyService {
    List<CurrencyDto> getAll();

    CurrencyDto createCurrency(Integer requestingUserId, @Validated CurrencyDto dto);

    CurrencyDto deleteCurrencyById(Integer requestingUserId, Integer currencyId);

}
