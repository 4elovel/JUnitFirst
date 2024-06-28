package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private static final Map<String, BigDecimal> currencies;

    static {
        currencies = new HashMap<>();
        currencies.put("USD", new BigDecimal("40.55"));
        currencies.put("EUR", new BigDecimal("43.60"));
        currencies.put("GBP", new BigDecimal("50.26"));
        currencies.put("JPY", new BigDecimal("0.210"));
        currencies.put("UAH", BigDecimal.ONE);
    }

    public static BigDecimal convert(BigDecimal amount, String currencyCode1,
            String currencyCode2) {
        if (currencyCode1 != null && currencyCode2 != null
                && currencies.containsKey(currencyCode1)
                && currencies.containsKey(currencyCode2)
                && amount.signum() >= 0) {

            BigDecimal rate1 = currencies.get(currencyCode1);
            BigDecimal rate2 = currencies.get(currencyCode2);

            BigDecimal result = amount.multiply(rate1).divide(rate2, 2, RoundingMode.HALF_UP);
            return result.setScale(2, RoundingMode.HALF_UP);
        }

        return new BigDecimal("-1");
    }
}
