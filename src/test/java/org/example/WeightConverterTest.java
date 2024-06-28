package org.example;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WeightConverterTest {

    private static Stream<Arguments> weightConversionParams() {
        return Stream.of(
                Arguments.of(1000.0, "mg", "g", 1.0),
                Arguments.of(500.0, "g", "kg", 0.5),
                Arguments.of(1.0, "kg", "g", 1000.0),
                Arguments.of(2.5, "centner", "tonne", 0.25),
                Arguments.of(1.0, "tonne", "kg", 1000.0)
        );
    }

    private static Stream<Arguments> invalidWeightConversionParams() {
        return Stream.of(
                Arguments.of(50.0, "g", "unknown"),
                Arguments.of(50.0, "ga", "g")
        );
    }

    @ParameterizedTest
    @MethodSource("weightConversionParams")
    public void testConvertWeight(double value, String fromUnit, String toUnit, double expected) {
        Assertions.assertEquals(expected, WeightConverter.convert(value, fromUnit, toUnit), 0.0001);
    }

    @ParameterizedTest
    @MethodSource("invalidWeightConversionParams")
    public void testInvalidConvertWeight(double value, String fromUnit, String toUnit) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WeightConverter.convert(value, fromUnit, toUnit);
        });
    }
}
