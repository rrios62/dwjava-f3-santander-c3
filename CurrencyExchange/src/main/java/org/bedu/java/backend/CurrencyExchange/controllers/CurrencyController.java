package org.bedu.java.backend.CurrencyExchange.controllers;

import org.bedu.java.backend.CurrencyExchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("currencies")
@Validated
public class CurrencyController {
    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    // GET /api/v1/currencies -> Muestra la lista de las monedas disponibles
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<String> getCurrencies() {
        return currencyService.getAllCurrencies();
    }

    // GET /api/v1/currencies/{currency} -> Muestra el tipo de cambio de la moneda
    @GetMapping("{currency}")
    public Map<String, Double> getExchangeRates(@PathVariable("currency") String currency) {
        return currencyService.getExchangeRates(currency);
    }

    // GET /api/v1/currencies/{currency}/exchanges/{amount} -> Muestra el tipo de cambio de cierta cantidad de la moneda
    @GetMapping("{currency}/exchanges/{amount}")
    public Map<String, Double> getExchangeAmount(@PathVariable("currency") String currency,
                                                 @PathVariable("amount") double amount) {
        return currencyService.getExchangeAmount(currency, amount);
    }
}
