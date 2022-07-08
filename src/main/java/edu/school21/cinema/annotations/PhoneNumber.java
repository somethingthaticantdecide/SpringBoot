package edu.school21.cinema.annotations;

import edu.school21.cinema.validators.PhoneNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PhoneNumberConstraintValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface PhoneNumber {

    String message() default "Invalid Phone Number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}