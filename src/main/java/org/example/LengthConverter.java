package org.example;

public class LengthConverter {

    public static double convert(double value, String fromUnit, String toUnit) {
        double meters = toMeters(value, fromUnit);
        return fromMeters(meters, toUnit);
    }

    private static double toMeters(double value, String unit) {
        return switch (unit.toLowerCase()) {
            case "mm" -> value / 1000.0;
            case "cm" -> value / 100.0;
            case "dm" -> value / 10.0;
            case "m" -> value;
            case "km" -> value * 1000.0;
            default -> throw new IllegalArgumentException("Invalid unit");
        };
    }

    private static double fromMeters(double value, String unit) {
        return switch (unit.toLowerCase()) {
            case "mm" -> value * 1000.0;
            case "cm" -> value * 100.0;
            case "dm" -> value * 10.0;
            case "m" -> value;
            case "km" -> value / 1000.0;
            default -> throw new IllegalArgumentException("Invalid unit");
        };
    }
}

