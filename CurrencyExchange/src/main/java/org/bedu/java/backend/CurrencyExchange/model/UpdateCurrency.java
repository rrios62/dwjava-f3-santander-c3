package org.bedu.java.backend.CurrencyExchange.model;

import org.bedu.java.backend.CurrencyExchange.validation.GlobalInterface;

public class UpdateCurrency {

    //@GlobalInterface
    private Double coinValue;

    public UpdateCurrency() {

    }

    public UpdateCurrency(Double coinValue) {
        this.coinValue = coinValue;
    }

    public Double getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(Double coinValue) {
        this.coinValue = coinValue;
    }
}
