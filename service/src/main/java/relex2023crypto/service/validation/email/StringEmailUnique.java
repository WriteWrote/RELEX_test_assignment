package relex2023crypto.service.validation.email;

import org.springframework.beans.factory.annotation.Autowired;
import relex2023crypto.db.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringEmailUnique implements ConstraintValidator<EmailUnique, String> {

    private final UserRepository userRepository;

    @Autowired
    public StringEmailUnique(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return !userRepository.existsByEmailIgnoreCase(value);
    }
}
