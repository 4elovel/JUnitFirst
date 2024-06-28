package org.example;

public class WeightConverter {

    public static double convert(double value, String fromUnit, String toUnit) {
        double grams = toGrams(value, fromUnit);
        return fromGrams(grams, toUnit);
    }

    private static double toGrams(double value, String unit) {
        return switch (unit.toLowerCase()) {
            case "mg" -> value / 1000.0;
            case "g" -> value;
            case "kg" -> value * 1000.0;
            case "centner" -> value * 100000.0;
            case "tonne" -> value * 1000000.0;
            default -> throw new IllegalArgumentException("Invalid unit");
        };
    }

    private static double fromGrams(double value, String unit) {
        return switch (unit.toLowerCase()) {
            case "mg" -> value * 1000.0;
            case "g" -> value;
            case "kg" -> value / 1000.0;
            case "centner" -> value / 100000.0;
            case "tonne" -> value / 1000000.0;
            default -> throw new IllegalArgumentException("Invalid unit");
        };
    }
}

