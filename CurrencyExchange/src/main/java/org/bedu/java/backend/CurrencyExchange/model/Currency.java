package org.bedu.java.backend.CurrencyExchange.model;

import org.bedu.java.backend.CurrencyExchange.validation.CoinValueValidation;
import org.bedu.java.backend.CurrencyExchange.validation.GlobalInterface;
import org.bedu.java.backend.CurrencyExchange.validation.MoneyValidation;

public class Currency {

    @GlobalInterface(validators = {MoneyValidation.class},
            message = "El código de la moneda deben ser 3 caracteres y no debe ir vacío")
            private String code;

    @GlobalInterface(validators = {CoinValueValidation.class},
            message = "Solo se admiten  y no debe ir vacío")
            private Double coinValue;

    public Currency(String code, Double coinValue) {
        this.code = code;
        this.coinValue = coinValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(Double coinValue) {
        this.coinValue = coinValue;
    }
}
