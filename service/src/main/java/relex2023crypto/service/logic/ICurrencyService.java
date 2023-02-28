package relex2023crypto.service.logic;

import org.springframework.validation.annotation.Validated;
import relex2023crypto.service.model.CurrencyDto;
import relex2023crypto.service.model.responses.CurrencySumDto;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.responses.SecretKeyDto;

import java.util.List;

public interface ICurrencyService {
    List<CurrencyDto> getAll();

    ResponseDto<CurrencyDto> createCurrency(Integer requestingUserId, @Validated CurrencyDto dto);

    ResponseDto<Integer> deleteCurrencyById(Integer requestingUserId, Integer currencyId);

    ResponseDto<CurrencySumDto> checkCurrencySum(Integer currencyId, SecretKeyDto dto);
}
