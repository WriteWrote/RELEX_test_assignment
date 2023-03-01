package relex2023crypto.service.validation.login;

import java.lang.annotation.Documented;
import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StringLoginUnique.class, LoginUniqueForUpdate.class})
public @interface LoginUnique {
    String message() default "login.already-exists";

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};
}
