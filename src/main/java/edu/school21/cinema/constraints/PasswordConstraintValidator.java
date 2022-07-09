package edu.school21.cinema.constraints;

import edu.school21.cinema.annotations.ValidPassword;
import org.passay.*;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword arg0) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(8, 60));
        rules.add(new WhitespaceRule());
        rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        rules.add(new CharacterRule(EnglishCharacterData.Special, 1));

        Properties props = new Properties();
        PasswordValidator validator;
        Locale locale = LocaleContextHolder.getLocale();
        try {
            if (locale.equals(new Locale("ru"))) {
                props.load(this.getClass().getResourceAsStream("/messages_ru.properties"));
            } else {
                props.load(this.getClass().getResourceAsStream("/messages_en.properties"));
            }
            MessageResolver resolver = new PropertiesMessageResolver(props);
            validator = new PasswordValidator(resolver, rules);
        } catch (IOException e) {
            validator = new PasswordValidator(rules);
            e.printStackTrace();
        }
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        List<String> messages = validator.getMessages(result);
        String messageTemplate = String.join(",", messages);
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}