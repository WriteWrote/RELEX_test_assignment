package relex2023crypto.db.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "exchange_rates", schema = "tar2023_crypto")
@Validated
public class ExchangeRateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "currency_from")
    private Integer currencyFrom;

    @Column(name = "currency_to")
    private Integer currencyTo;

    @Column(name = "coef")
    private Double coef;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(Integer currency1) {
        this.currencyFrom = currency1;
    }

    public Integer getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(Integer currency2) {
        this.currencyTo = currency2;
    }

    public Double getCoef() {
        return coef;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }
}
