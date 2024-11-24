package org.example;

/**
 * A class that calculates areas of various geometric shapes.
 * It uses the Calculator class to perform basic arithmetic operations.
 */
public class AreaCalculator {
    private final Calculator calculator;

    /**
     * Constructor for AreaCalculator.
     *
     * @param calculator an instance of the Calculator class for arithmetic operations
     */
    public AreaCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Calculates the area of a circle.
     *
     * @param radius the radius of the circle
     * @return the area of the circle
     * @throws IllegalArgumentException if the radius is negative
     */
    public double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }

        // Area of a circle = π * radius^2
        double radiusSquared = calculator.multiply(radius, radius);
        return calculator.multiply(Math.PI, radiusSquared);
    }

    /**
     * Calculates the area of a rectangle.
     *
     * @param length  the length of the rectangle
     * @param breadth the breadth of the rectangle
     * @return the area of the rectangle
     * @throws IllegalArgumentException if length or breadth is negative
     */
    public double calculateRectangleArea(double length, double breadth) {
        if (length < 0 || breadth < 0) {
            throw new IllegalArgumentException("Length and breadth cannot be negative");
        }

        // Area of a rectangle = length * breadth
        return calculator.multiply(length, breadth);
    }

    /**
     * Calculates the area of a triangle.
     *
     * @param base   the base of the triangle
     * @param height the height of the triangle
     * @return the area of the triangle
     * @throws IllegalArgumentException if base or height is negative
     */
    public double calculateTriangleArea(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Base and height cannot be negative");
        }

        // Area of a triangle = 0.5 * base * height
        double baseHeightProduct = calculator.multiply(base, height);
        return calculator.multiply(0.5, baseHeightProduct);
    }

    /**
     * Calculates the area of a square.
     *
     * @param side the side length of the square
     * @return the area of the square
     * @throws IllegalArgumentException if the side is negative
     */
    public double calculateSquareArea(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side cannot be negative");
        }

        // Area of a square = side^2
        return calculator.multiply(side, side);
    }
}
