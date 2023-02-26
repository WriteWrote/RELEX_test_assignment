package relex2023crypto.service.logic;

import relex2023crypto.service.model.ExchangeRateDto;

import java.util.List;

public interface IExchangeRateService {
    ExchangeRateDto getExchangeRateById(Integer first, Integer second);

    List<ExchangeRateDto> getAll();
    ExchangeRateDto modifyExchangeRateById(Integer requestingUserId,
                                           ExchangeRateDto dto);

}
