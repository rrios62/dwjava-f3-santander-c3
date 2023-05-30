package org.bedu.java.backend.CurrencyExchange.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MoneyValidation implements ConstraintValidator<GlobalInterface, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("^[a-zA-Z]{3}$");//Valída que sean solo caracteres y que sean 3
    }
}
