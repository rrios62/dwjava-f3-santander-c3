package org.bedu.java.backend.CurrencyExchange.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CoinValueValidation implements ConstraintValidator<GlobalInterface, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("^(\\d{1,10}(\\.\\d+)?)$") && Float.parseFloat(value) > 0;//Valída numero flotantes que no sean 0 y nulos
    }
}
