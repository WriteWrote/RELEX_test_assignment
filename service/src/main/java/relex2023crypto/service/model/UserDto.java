package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import relex2023crypto.db.entities.WalletEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor
public class UserDto {
    @JsonProperty("id")
    @NotNull
    private Integer id;

    @JsonProperty("login")
    @NotBlank(message = "login.is-blank")
    private String login;

    @JsonProperty("wallets")
    private List<WalletDto> wallets;

    @JsonProperty("transactions")
    private List<TransactionDto> transactions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<WalletDto> getWallets() {
        return wallets;
    }

    public void setWallets(List<WalletDto> wallets) {
        this.wallets = wallets;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }
}
