package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import relex2023crypto.service.validation.EmailUnique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RequiredArgsConstructor
public class AdminDto {
    @JsonProperty("id")
    @NotNull
    private Integer id;

//    @JsonProperty("secret_key")
//    @NotBlank
//    private String secretKey;

    @JsonProperty("email")
    @EmailUnique
    @Email(message = "email.invalid")
    @NotBlank
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getSecretKey() {
//        return secretKey;
//    }

//    public void setSecretKey(String secretKey) {
//        this.secretKey = secretKey;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}