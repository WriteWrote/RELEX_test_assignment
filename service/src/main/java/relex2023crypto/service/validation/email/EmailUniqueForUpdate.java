package relex2023crypto.service.validation.email;

import org.springframework.beans.factory.annotation.Autowired;
import relex2023crypto.db.repositories.UserRepository;
import relex2023crypto.service.model.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueForUpdate implements ConstraintValidator<EmailUnique, UserDto> {

    private final UserRepository userRepository;

    @Autowired
    public EmailUniqueForUpdate(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(UserDto value, ConstraintValidatorContext context) {
        if (value == null || value.getId() == null || value.getEmail() == null) {
            return true;
        }

        return !userRepository.existsByIdIsNotAndEmailIgnoreCase(value.getId(), value.getLogin());
    }
}
