package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class CurrencyDto {
    @JsonProperty("id")
    @NotBlank(message = "id.is-blank")
    private Integer id;


    @JsonProperty("currency_name")
    @NotBlank(message = "currencyName.is-blank")
    private String currencyName;
}
