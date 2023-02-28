package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.ICurrencyService;
import relex2023crypto.service.model.CurrencyDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;

@RestController
@RequestMapping("users/{requestingUserId}/cash/currency")
public class CurrencyController {
    private final ICurrencyService service;

    @Autowired
    public CurrencyController(ICurrencyService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<CurrencyDto> getAllCurrencies(){
        return service.getAll();
    }

    @PostMapping("/create")
    public CurrencyDto createCurrency(@PathVariable Integer requestingUserId,
                                      @RequestBody CurrencyDto dto){
        return service.createCurrency(requestingUserId, dto);
    }

    @DeleteMapping("/delete/{currencyId}")
    public ResponseDto deleteCurrency(@PathVariable Integer requestingUserId,
                                      @PathVariable Integer currencyId){
        return service.deleteCurrencyById(requestingUserId, currencyId);
    }
}
