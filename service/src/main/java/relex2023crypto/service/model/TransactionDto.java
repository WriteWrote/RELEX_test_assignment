package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@RequiredArgsConstructor
public class TransactionDto {
    @JsonProperty("id")
    @NotNull
    private Integer id;

    @JsonProperty("secret_key")
    @NotNull
    private String secretKey;

    @JsonProperty("wallet_id")
    @NotNull
    private Integer walletId;

    @JsonProperty("currency_id")
    @NotNull
    private Integer currencyId;

    @JsonProperty("sum")
    @NotNull
    private Double sum;

    @JsonProperty("message")
    @NotBlank(message = "message.is-blank")
    private String message;

    @JsonProperty("date")
    @NotBlank(message = "date.is-blank")
    @PastOrPresent
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyToId) {
        this.currencyId = currencyToId;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletToId) {
        this.walletId = walletToId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
