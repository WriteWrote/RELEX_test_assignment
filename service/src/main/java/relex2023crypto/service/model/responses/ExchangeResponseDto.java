package relex2023crypto.service.model.responses;

import lombok.RequiredArgsConstructor;

import java.util.Date;

public class ExchangeResponseDto {
    //todo: когда буду добавлять в таблицу transaction колонку с датой, поменять
    // все парные колонки с currency1/2 на currencyFrom/To
    private Integer currencyFromId;
    private Double sumFrom;
    private Integer currencyToId;
    private Double sumTo;
    private Date date;

    public ExchangeResponseDto(Integer currencyFromId, Double sumFrom, Integer currencyToId, Double sumTo, Date date) {
        this.currencyFromId = currencyFromId;
        this.sumFrom = sumFrom;
        this.currencyToId = currencyToId;
        this.sumTo = sumTo;
        this.date = date;
    }

    public Integer getCurrencyFromId() {
        return currencyFromId;
    }

    public void setCurrencyFromId(Integer currencyFromId) {
        this.currencyFromId = currencyFromId;
    }

    public Integer getCurrencyToId() {
        return currencyToId;
    }

    public void setCurrencyToId(Integer currencyToId) {
        this.currencyToId = currencyToId;
    }

    public Double getSumFrom() {
        return sumFrom;
    }

    public void setSumFrom(Double sumFrom) {
        this.sumFrom = sumFrom;
    }

    public Double getSumTo() {
        return sumTo;
    }

    public void setSumTo(Double sumTo) {
        this.sumTo = sumTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
