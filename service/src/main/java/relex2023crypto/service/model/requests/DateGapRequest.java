package relex2023crypto.service.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class DateGapRequest {
    @JsonProperty("date_from")
    private Date dateFrom;
    @JsonProperty("date_to")
    private Date dateTo;

    @JsonProperty("secret_key")
    private String secretKey;

    public DateGapRequest(@JsonProperty("date_from") Date dateFrom,
                          @JsonProperty("date_to") Date dateTo,
                          @JsonProperty("secret_key") String secretKey) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.secretKey = secretKey;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
