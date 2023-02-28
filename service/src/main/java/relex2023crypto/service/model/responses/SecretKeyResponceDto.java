package relex2023crypto.service.model.responses;

import lombok.RequiredArgsConstructor;
public class SecretKeyResponceDto {
    private String secretKey;

    public SecretKeyResponceDto(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
