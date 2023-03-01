package relex2023crypto.db.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "wallets", schema = "tar2023_crypto")
@Validated
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false)
    private UserEntity user;

    @Column(name = "currency_id")
    private Integer currencyId;

    @Column(name = "currency_sum")
    @Positive(message = "currencySum in walletEntity must not be empty")
    private Double currencySum;

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
}
