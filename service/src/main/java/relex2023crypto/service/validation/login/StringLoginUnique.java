package relex2023crypto.service.validation.login;

import org.springframework.beans.factory.annotation.Autowired;
import relex2023crypto.db.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringLoginUnique implements ConstraintValidator<LoginUnique, String> {

    private final UserRepository userRepository;

    @Autowired
    public StringLoginUnique(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return !userRepository.existsByLoginIgnoreCase(value);
    }
}
