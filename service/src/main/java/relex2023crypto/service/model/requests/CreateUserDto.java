package relex2023crypto.service.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import relex2023crypto.service.model.UserDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
public class CreateUserDto extends UserDto {
    @NotBlank
    @Size(min = 5, max = 50)
    @JsonProperty("password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
