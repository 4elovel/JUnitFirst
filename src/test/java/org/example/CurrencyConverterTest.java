package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CurrencyConverterTest {

    @ParameterizedTest
    @CsvSource({
            "100, USD, EUR, 93.00",
            "200, GBP, USD, 247.89",
            "300, JPY, UAH, 63.00",
            "400, EUR, GBP, 347.00",
            "500, UAH, USD, 12.33"
    })
    public void testConvert(String amountStr, String fromCurrency, String toCurrency,
            String expectedStr) {
        BigDecimal amount = new BigDecimal(amountStr);
        BigDecimal expected = new BigDecimal(expectedStr);

        assertEquals(expected.setScale(2, RoundingMode.HALF_UP),
                CurrencyConverter.convert(amount, fromCurrency, toCurrency)
                        .setScale(2, RoundingMode.HALF_UP));
    }

    @ParameterizedTest
    @CsvSource({
            "-100, USD, EUR",
            "-50, EUR, USD",
            "-75, GBP, JPY"
    })
    public void testConvertWithNegativeAmount(String amountStr, String fromCurrency,
            String toCurrency) {
        BigDecimal amount = new BigDecimal(amountStr);

        assertEquals(new BigDecimal(-1),
                CurrencyConverter.convert(amount, fromCurrency, toCurrency));
    }

    @ParameterizedTest
    @CsvSource({
            "100, USD, INVALID",
            "50, INVALID, EUR",
            "75, GBP, INVALID"
    })
    public void testConvertWithInvalidCurrency(String amountStr, String fromCurrency,
            String toCurrency) {
        BigDecimal amount = new BigDecimal(amountStr);

        assertEquals(new BigDecimal(-1),
                CurrencyConverter.convert(amount, fromCurrency, toCurrency));
    }

    @ParameterizedTest
    @CsvSource({
            "100, null, EUR",
            "50, USD, null",
            "75, null, null"
    })
    public void testConvertWithNullCurrency(String amountStr, String fromCurrency,
            String toCurrency) {
        BigDecimal amount = new BigDecimal(amountStr);

        assertEquals(new BigDecimal(-1),
                CurrencyConverter.convert(amount, fromCurrency, toCurrency));
    }


}
