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

    @Column(name = "currency_id1")
    @NotEmpty(message = "currencyid1 in currencyEntity must not be empty")
    private Integer currency1;

    @Column(name = "currency_id2")
    @NotEmpty(message = "currencyid2 in currencyEntity must not be empty")
    private Integer currency2;

    @Column(name = "coef")
    @NotEmpty(message = "coef in ExchangeRate must not be empty")
    private Double coef;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrency1() {
        return currency1;
    }

    public void setCurrency1(Integer currency1) {
        this.currency1 = currency1;
    }

    public Integer getCurrency2() {
        return currency2;
    }

    public void setCurrency2(Integer currency2) {
        this.currency2 = currency2;
    }

    public Double getCoef() {
        return coef;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }
}
