package org.example;

public class AreaService {

    public static double triangleArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be greater than zero");
        }
        return 0.5 * base * height;
    }

    public static double rectangleArea(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be greater than zero");
        }
        return length * width;
    }

    public static double squareArea(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be greater than zero");
        }
        return side * side;
    }

    public static double rhombusArea(double diagonal1, double diagonal2) {
        if (diagonal1 <= 0 || diagonal2 <= 0) {
            throw new IllegalArgumentException("Diagonals must be greater than zero");
        }
        return 0.5 * diagonal1 * diagonal2;
    }
}