package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import relex2023crypto.db.entities.WalletEntity;
import relex2023crypto.service.validation.EmailUnique;
import relex2023crypto.service.validation.login.LoginUnique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@RequiredArgsConstructor
public class UserDto {
    @JsonProperty("id")
    @NotNull
    private Integer id;

    @JsonProperty("login")
    @Pattern(regexp = "^[a-zA-Z\\d]{5,50}$", message = "login.invalid")
    @LoginUnique
    @NotBlank(message = "login.is-blank")
    private String login;

    @JsonProperty("email")
    @Email(message = "email.invalid")
    @EmailUnique
    private String email;

    @JsonProperty("secret_key")
    @NotBlank
    private String secretKey;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
