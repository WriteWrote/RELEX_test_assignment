package relex2023crypto.db.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "transactions", schema = "tar2023_crypto")
@Validated
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false)
    private UserEntity user;
    @Column(name = "wallet_id")
    private Integer walletId;

    @Column(name = "currency_id")
    private Integer currencyId;

    @Column(name = "currency_sum")
    private Double currencySum;

    @Column(name = "date")
    private Date date;

    @Column(name = "message")
    @NotEmpty(message = "additional message in TransactionEntity must not be empty")
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Double getCurrencySum() {
        return currencySum;
    }

    public void setCurrencySum(Double currencySum) {
        this.currencySum = currencySum;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
