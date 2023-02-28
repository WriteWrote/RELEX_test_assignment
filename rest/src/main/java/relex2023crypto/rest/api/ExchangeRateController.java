package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.IExchangeRateService;
import relex2023crypto.service.model.ExchangeRateDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;

@RestController
@RequestMapping("user/cash/rate")
public class ExchangeRateController {
    private final IExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateController(IExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("{currency1}/{currency2}")
    public ExchangeRateDto getCurrencyExchangeRate(@PathVariable Integer currency1,
                                                   @PathVariable Integer currency2) {
        return exchangeRateService.getExchangeRateById(currency1, currency2);
    }

    @GetMapping("/all")
    public List<ExchangeRateDto> getAllExchangeRates(){
        return exchangeRateService.getAll();
    }

    @PostMapping("/modify")
    public ResponseDto<ExchangeRateDto> modifyCurrencyExchangeRate(@RequestBody ExchangeRateDto dto){
        return exchangeRateService.modifyExchangeRateById(dto);
    }

}
