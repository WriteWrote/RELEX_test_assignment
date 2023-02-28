package relex2023crypto.service.model.responses;

public class SecretKeyDto {
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
