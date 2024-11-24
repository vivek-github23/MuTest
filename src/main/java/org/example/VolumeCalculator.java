package org.example;

public class VolumeCalculator {
    private final Calculator calculator;

    public VolumeCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public double calculateSphereVolume(double radius) {
        double radiusCubed = calculator.multiply(radius, calculator.multiply(radius, radius));
        return calculator.multiply(4.0 / 3.0, calculator.multiply(Math.PI, radiusCubed));
    }

    public double calculateCubeVolume(double side) {
        return calculator.multiply(side, calculator.multiply(side, side));
    }

    public double calculateCylinderVolume(double radius, double height) {
        double radiusSquared = calculator.multiply(radius, radius);
        return calculator.multiply(Math.PI, calculator.multiply(radiusSquared, height));
    }

    public double calculateRectangularPrismVolume(double length, double width, double height) {
        return calculator.multiply(length, calculator.multiply(width, height));
    }
}
