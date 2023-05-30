package org.bedu.java.backend.CurrencyExchange.service;

import org.bedu.java.backend.CurrencyExchange.model.Currency;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CurrencyService {
    private Map<String, Double> exchangeRates;

    public CurrencyService() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("MXN", 0.056);
        exchangeRates.put("USD", 1.12);
        exchangeRates.put("EUR", 1.04);

    }

    public List<String> getAllCurrencies() {
        return new ArrayList<>(exchangeRates.keySet());
    }

    public Map<String, Double> getExchangeRates(String currency) {
        Map<String, Double> rates = new HashMap<>();
        for (String key : exchangeRates.keySet()) {
            if (!key.equals(currency)) {
                rates.put(key, exchangeRates.get(key));
            }
        }
        return rates;
    }

    public Map<String, Double> getExchangeAmount(String currency, double amount) {
        Map<String, Double> exchangedAmounts = new HashMap<>();
        for (String key : exchangeRates.keySet()) {
            if (!key.equals(currency)) {
                double exchangeRate = exchangeRates.get(key);
                double exchangedAmount = amount * exchangeRate;
                exchangedAmounts.put(key, exchangedAmount);
            }
        }
        return exchangedAmounts;
    }
    public void addCurrency(String code, String coinName) {
        // Verificar si la moneda ya existe en exchangeRates
        if (exchangeRates.containsKey(code)) {
            throw new IllegalArgumentException("La moneda ya existe en el sistema.");
        }
        exchangeRates.put(code, 0.0);
    }

    public void updateCurrency(String currency, String code, String coinName) {
        // Verificar si la moneda a actualizar existe en exchangeRates
        if (!exchangeRates.containsKey(currency)) {
            throw new IllegalArgumentException("La moneda no existe en el sistema.");
        }
        // Actualizar el código y nombre de la moneda
        Double exchangeRate = exchangeRates.get(currency);
        exchangeRates.remove(currency);
        exchangeRates.put(code, exchangeRate);
    }

    public void deleteCurrency(String currency) {
        // Verificar si la moneda a eliminar existe en exchangeRates
        if (!exchangeRates.containsKey(currency)) {
            throw new IllegalArgumentException("La moneda no existe en el sistema.");
        }
        // Eliminar la moneda del mapa exchangeRates
        exchangeRates.remove(currency);
    }
}