package org.example;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LengthConverterTest {

    private static Stream<Arguments> lengthConversionParams() {
        return Stream.of(
                Arguments.of(1000.0, "mm", "m", 1.0),
                Arguments.of(50.0, "cm", "m", 0.5),
                Arguments.of(10.0, "dm", "m", 1.0),
                Arguments.of(1.0, "m", "km", 0.001),
                Arguments.of(2.5, "km", "m", 2500.0)
        );
    }

    private static Stream<Arguments> invalidLengthConversionParams() {
        return Stream.of(
                Arguments.of(50.0, "unknown", "m"),
                Arguments.of(50.0, "m", "ma")
        );
    }

    @ParameterizedTest
    @MethodSource("lengthConversionParams")
    public void testConvertLength(double value, String fromUnit, String toUnit, double expected) {
        Assertions.assertEquals(expected, LengthConverter.convert(value, fromUnit, toUnit), 0.0001);
    }

    @ParameterizedTest
    @MethodSource("invalidLengthConversionParams")
    public void testInvalidConvertLength(double value, String fromUnit, String toUnit) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LengthConverter.convert(value, fromUnit, toUnit);
        });
    }
}
