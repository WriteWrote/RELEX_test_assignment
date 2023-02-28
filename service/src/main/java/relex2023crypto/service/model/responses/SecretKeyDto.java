package relex2023crypto.service.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
public class SecretKeyDto {
    @JsonProperty("secret_key")
    @NotBlank(message = "secret key must not be blank")
    private String secretKey;

    public SecretKeyDto(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
