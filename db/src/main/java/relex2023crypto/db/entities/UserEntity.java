package relex2023crypto.db.entities;

import liquibase.pro.packaged.C;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users", schema = "tar2023_crypto")
@Validated
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    @NotEmpty(message = "login must not be empty")
    @Size(min = 4, max = 50, message = "login must be from 4 to 50 characters")
    private String login;

    @Column(name = "email")
    @NotEmpty(message = "email must not be empty")
    private String email;

    @Column(name = "secret_key")
    @NotEmpty(message = "secret key must not be empty")
    private String secretKey;

    @Column(name = "password")
    @Size(min = 8, max=50, message = "password must be from 8 t 50 characters")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<WalletEntity> wallets;

    @OneToMany(mappedBy = "user")
    private List<TransactionEntity> transactionsHistory;

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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<WalletEntity> getWallets() {
        return wallets;
    }

    public void setWallets(List<WalletEntity> wallets) {
        this.wallets = wallets;
    }

    public List<TransactionEntity> getTransactionsHistory() {
        return transactionsHistory;
    }

    public void setTransactionsHistory(List<TransactionEntity> transactionsHistory) {
        this.transactionsHistory = transactionsHistory;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
