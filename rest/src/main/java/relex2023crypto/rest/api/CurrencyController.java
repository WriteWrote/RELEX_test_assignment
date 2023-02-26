package relex2023crypto.rest.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.ICurrencyService;
import relex2023crypto.service.model.CurrencyDto;

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
    public void deleteCurrency(@PathVariable Integer requestingUserId,
                                      @PathVariable Integer currencyId){
        service.deleteCurrencyById(requestingUserId, currencyId);
    }
}
