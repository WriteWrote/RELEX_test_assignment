package relex2023crypto.rest.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.ICurrencyService;
import relex2023crypto.service.model.CurrencyDto;

import java.util.List;

@RestController
@RequestMapping("users/{requestingUserId}/cash/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final ICurrencyService service;

    @GetMapping("/all")
    public List<CurrencyDto> getAllCurrencies(){
        return service.getAllCurrencies();
    }

    @PostMapping("/create")
    public CurrencyDto createCurrency(@PathVariable Integer requestingUserId,
                                      @RequestBody CurrencyDto dto){
        return service.createCurrensy(requestingUserId, dto);
    }

    @DeleteMapping("/delete/{currencyId}")
    public CurrencyDto deleteCurrency(@PathVariable Integer requestingUserId,
                                      @PathVariable Integer currencyId){
        return service.deleteCurrencyById(requestingUserId, currencyId);
    }
}
