package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    public Integer getCurrency_id1() {
        return currency_id1;
    }

    public Integer getCurrency_id2() {
        return currency_id2;
    }

    public void setCurrency_id2(Integer currency_id2) {
        this.currency_id2 = currency_id2;
    }

    public Double getCoef() {
        return coef;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }

    public void setCurrency_id1(Integer currency_id1) {
        this.currency_id1 = currency_id1;
    }
}
