package relex2023crypto.db.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "transactions", schema = "tar2023_crypto")
@Validated
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    @NotEmpty(message = "userId in transactionEntity must not be empty")
    private Integer userId;

    @Column(name = "currency_id")
    @NotEmpty(message = "currencyId in TransactionEntity must not be empty")
    private Integer currencyId;

    @Column(name = "currency_sum")
    @NotEmpty(message = "currencySum in TransactionEntity must not be empty")
    private Double currencySum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
