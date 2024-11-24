package org.example;

public class AreaCalculator {
    private final Calculator calculator;

    public AreaCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        double radiusSquared = calculator.multiply(radius, radius);
        return calculator.multiply(Math.PI, radiusSquared);
    }

    public double calculateRectangleArea(double length, double breadth) {
        if (length < 0 || breadth < 0) {
            throw new IllegalArgumentException("Length and breadth cannot be negative");
        }
        return calculator.multiply(length, breadth);
    }

    public double calculateTriangleArea(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Base and height cannot be negative");
        }
        double baseHeightProduct = calculator.multiply(base, height);
        return calculator.multiply(0.5, baseHeightProduct);
    }

    public double calculateSquareArea(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side cannot be negative");
        }
        return calculator.multiply(side, side);
    }
}
