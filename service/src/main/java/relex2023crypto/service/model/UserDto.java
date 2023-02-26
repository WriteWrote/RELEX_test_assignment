package relex2023crypto.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    @JsonProperty("id")
    @NotNull
    private Integer id;

    @JsonProperty("login")
    @NotBlank(message = "login.is-blank")
    private String login;
}
