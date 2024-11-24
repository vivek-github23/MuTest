package org.example;

/**
 * A class that provides basic arithmetic and mathematical operations.
 * Operations include addition, subtraction, multiplication, division, exponentiation, logarithms, and trigonometric functions.
 */
public class Calculator {

    // Basic arithmetic operations

    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first number.
     *
     * @param a the number to subtract from
     * @param b the number to subtract
     * @return the result of a - b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the product of a and b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second number.
     *
     * @param a the numerator
     * @param b the denominator
     * @return the result of a / b
     * @throws ArithmeticException if b is zero (division by zero)
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    // Advanced operations

    /**
     * Raises the base to the power of the exponent.
     *
     * @param base  the base number
     * @param power the exponent to raise the base to
     * @return the result of base^power
     */
    public double exponent(double base, double power) {
        return Math.pow(base, power);
    }

    /**
     * Calculates the natural logarithm (base e) of a value.
     *
     * @param value the number whose logarithm is to be calculated
     * @return the natural logarithm of the value
     * @throws ArithmeticException if the value is less than or equal to zero
     */
    public double logarithm(double value) {
        if (value <= 0) {
            throw new ArithmeticException("Logarithm of non-positive numbers is undefined.");
        }
        return Math.log(value);
    }

    // Trigonometric functions

    /**
     * Calculates the sine of an angle (in degrees).
     *
     * @param angle the angle in degrees
     * @return the sine of the angle
     */
    public double sine(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    /**
     * Calculates the cosine of an angle (in degrees).
     *
     * @param angle the angle in degrees
     * @return the cosine of the angle
     */
    public double cosine(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    /**
     * Calculates the tangent of an angle (in degrees).
     *
     * @param angle the angle in degrees
     * @return the tangent of the angle
     */
    public double tangent(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
}
