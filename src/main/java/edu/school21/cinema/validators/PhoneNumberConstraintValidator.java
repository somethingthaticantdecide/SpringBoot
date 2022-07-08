package edu.school21.cinema.validators;

import edu.school21.cinema.annotations.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword arg0) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
//        Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
//        Matcher matcher = pattern.matcher(phone);
        return false;
    }
}