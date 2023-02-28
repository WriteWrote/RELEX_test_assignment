package relex2023crypto.service.logic;

import relex2023crypto.service.model.ExchangeRateDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;

public interface IExchangeRateService {
    ExchangeRateDto getExchangeRateById(Integer first, Integer second);

    List<ExchangeRateDto> getAll();
    ResponseDto<ExchangeRateDto> modifyExchangeRateById(Integer requestingUserId,
                                                       ExchangeRateDto dto);

}
