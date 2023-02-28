package relex2023crypto.service.model.responses;

public class CurrencySumDto {
    private String name;
    private Double sum;

    public CurrencySumDto(String name, Double sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
