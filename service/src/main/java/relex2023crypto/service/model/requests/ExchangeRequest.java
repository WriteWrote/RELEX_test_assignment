package relex2023crypto.service.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import relex2023crypto.service.model.TransactionDto;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
public class ExchangeRequest extends TransactionDto {
    @JsonProperty("wallet_to_id")
    @NotNull
    private Integer walletToId;

    @JsonProperty("currency_to_id")
    @NotNull
    private Integer currencyToId;

    public Integer getWalletToId() {
        return walletToId;
    }

    public void setWalletToId(Integer walletToId) {
        this.walletToId = walletToId;
    }

    public Integer getCurrencyToId() {
        return currencyToId;
    }

    public void setCurrencyToId(Integer currencyToId) {
        this.currencyToId = currencyToId;
    }


}
