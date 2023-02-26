package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
public class TransactionDto {
    @JsonProperty("id")
    @NotNull
    private Integer id;

    @JsonProperty("user_id")
    @NotNull
    private Integer userId;

    @JsonProperty("currency_id")
    @NotNull
    private Integer currencyId;

    @JsonProperty("sum")
    @NotNull
    private Double sum;

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

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
