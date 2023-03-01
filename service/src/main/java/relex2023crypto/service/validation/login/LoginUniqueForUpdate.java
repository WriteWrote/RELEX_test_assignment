package relex2023crypto.service.validation.login;

import org.springframework.beans.factory.annotation.Autowired;
import relex2023crypto.db.repositories.UserRepository;
import relex2023crypto.service.model.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginUniqueForUpdate implements ConstraintValidator<LoginUnique, UserDto> {
    private final UserRepository userRepository;

    @Autowired
    public LoginUniqueForUpdate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(UserDto value, ConstraintValidatorContext context) {
        if (value == null || value.getId() == null && value.getLogin() == null) {
            return true;
        }

        return !userRepository.existsByIdIsNotAndLoginIgnoreCase(value.getId(), value.getLogin());
    }
}
