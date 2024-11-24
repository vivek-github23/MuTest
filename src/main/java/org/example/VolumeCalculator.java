package org.example;

/**
 * A class that provides volume calculation methods for different 3D shapes like spheres, cubes, cylinders, and rectangular prisms.
 */
public class VolumeCalculator {
    private final Calculator calculator;

    /**
     * Constructor to initialize the VolumeCalculator with a Calculator instance.
     *
     * @param calculator an instance of the Calculator class to perform basic operations
     */
    public VolumeCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    // Volume calculation methods

    /**
     * Calculates the volume of a sphere using the formula:
     * Volume = (4/3) * π * r³
     *
     * @param radius the radius of the sphere
     * @return the volume of the sphere
     */
    public double calculateSphereVolume(double radius) {
        // Calculating r³ (radius cubed)
        double radiusCubed = calculator.multiply(radius, calculator.multiply(radius, radius));
        // Applying the formula (4/3) * π * r³
        return calculator.multiply(4.0 / 3.0, calculator.multiply(Math.PI, radiusCubed));
    }

    /**
     * Calculates the volume of a cube using the formula:
     * Volume = side³
     *
     * @param side the length of the side of the cube
     * @return the volume of the cube
     */
    public double calculateCubeVolume(double side) {
        // Calculating side³ (side cubed)
        return calculator.multiply(side, calculator.multiply(side, side));
    }

    /**
     * Calculates the volume of a cylinder using the formula:
     * Volume = π * r² * h
     *
     * @param radius the radius of the base of the cylinder
     * @param height the height of the cylinder
     * @return the volume of the cylinder
     */
    public double calculateCylinderVolume(double radius, double height) {
        // Calculating r² (radius squared)
        double radiusSquared = calculator.multiply(radius, radius);
        // Applying the formula π * r² * h
        return calculator.multiply(Math.PI, calculator.multiply(radiusSquared, height));
    }

    /**
     * Calculates the volume of a rectangular prism using the formula:
     * Volume = length * width * height
     *
     * @param length the length of the rectangular prism
     * @param width the width of the rectangular prism
     * @param height the height of the rectangular prism
     * @return the volume of the rectangular prism
     */
    public double calculateRectangularPrismVolume(double length, double width, double height) {
        // Applying the formula length * width * height
        return calculator.multiply(length, calculator.multiply(width, height));
    }
}
