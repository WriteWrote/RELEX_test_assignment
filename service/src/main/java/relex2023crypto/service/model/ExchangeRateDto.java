package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
public class ExchangeRateDto {
    @JsonProperty("currency1")
    @NotNull()
    private Integer currency_id1;

    @JsonProperty("currency2")
    @NotNull
    private Integer currency_id2;

    @JsonProperty("coef")
    @NotNull
    private Double coef;
}
