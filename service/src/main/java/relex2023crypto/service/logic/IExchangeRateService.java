package relex2023crypto.service.logic;

import relex2023crypto.service.model.requests.ExchangeRateDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;

public interface IExchangeRateService {
    ExchangeRateDto getExchangeRateById(Integer first, Integer second);

    ResponseDto<ExchangeRateDto> createExchangeRate(ExchangeRateDto dto);

    ResponseDto<Integer> deleteExchangeRate(Integer requestingUser,
                                            Integer rateId);

    List<ExchangeRateDto> getAll();

    ResponseDto<ExchangeRateDto> modifyExchangeRateById(ExchangeRateDto dto);
}
