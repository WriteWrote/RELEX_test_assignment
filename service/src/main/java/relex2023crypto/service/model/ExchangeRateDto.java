package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
public class ExchangeRateDto {
    @JsonProperty("currency1")
    @NotNull()
    private Integer currencyFrom;

    @JsonProperty("currency2")
    @NotNull
    private Integer currencyTo;

    @JsonProperty("coef")
    @NotNull
    private Double coef;

    @JsonProperty("secret_key")
    @NotNull
    private String requestingSecretKey;

    public Integer getCurrencyFrom() {
        return currencyFrom;
    }

    public Integer getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(Integer currencyTo) {
        this.currencyTo = currencyTo;
    }

    public Double getCoef() {
        return coef;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }

    public void setCurrencyFrom(Integer currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getRequestingSecretKey() {
        return requestingSecretKey;
    }

    public void setRequestingSecretKey(String requestingSecretKey) {
        this.requestingSecretKey = requestingSecretKey;
    }
}
