package org.example;

/**
 * A class that provides operations for complex numbers, such as addition, subtraction,
 * multiplication, division, magnitude calculation, phase calculation, and conjugate computation.
 */
public class ComplexNumberCalculator {
    private final Calculator calculator;

    /**
     * Constructor to initialize the ComplexNumberCalculator with a Calculator instance.
     *
     * @param calculator an instance of the Calculator class to perform basic operations
     */
    public ComplexNumberCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    // Basic operations on complex numbers

    /**
     * Adds two complex numbers.
     *
     * @param real1 the real part of the first complex number
     * @param imag1 the imaginary part of the first complex number
     * @param real2 the real part of the second complex number
     * @param imag2 the imaginary part of the second complex number
     * @return a string representation of the sum of the two complex numbers
     */
    public String add(double real1, double imag1, double real2, double imag2) {
        double real = calculator.add(real1, real2);
        double imag = calculator.add(imag1, imag2);
        return formatComplexNumber(real, imag);
    }

    /**
     * Subtracts the second complex number from the first.
     *
     * @param real1 the real part of the first complex number
     * @param imag1 the imaginary part of the first complex number
     * @param real2 the real part of the second complex number
     * @param imag2 the imaginary part of the second complex number
     * @return a string representation of the difference of the two complex numbers
     */
    public String subtract(double real1, double imag1, double real2, double imag2) {
        double real = calculator.subtract(real1, real2);
        double imag = calculator.subtract(imag1, imag2);
        return formatComplexNumber(real, imag);
    }

    /**
     * Multiplies two complex numbers.
     *
     * @param real1 the real part of the first complex number
     * @param imag1 the imaginary part of the first complex number
     * @param real2 the real part of the second complex number
     * @param imag2 the imaginary part of the second complex number
     * @return a string representation of the product of the two complex numbers
     */
    public String multiply(double real1, double imag1, double real2, double imag2) {
        double real = calculator.subtract(calculator.multiply(real1, real2), calculator.multiply(imag1, imag2));
        double imag = calculator.add(calculator.multiply(real1, imag2), calculator.multiply(imag1, real2));
        return formatComplexNumber(real, imag);
    }

    /**
     * Divides the first complex number by the second.
     *
     * @param real1 the real part of the numerator (first complex number)
     * @param imag1 the imaginary part of the numerator (first complex number)
     * @param real2 the real part of the denominator (second complex number)
     * @param imag2 the imaginary part of the denominator (second complex number)
     * @return a string representation of the quotient of the two complex numbers
     * @throws ArithmeticException if division by zero is attempted
     */
    public String divide(double real1, double imag1, double real2, double imag2) {
        double denominator = calculator.add(calculator.multiply(real2, real2), calculator.multiply(imag2, imag2));

        // Check for division by zero
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero in complex number division.");
        }

        double real = calculator.divide(
                calculator.add(calculator.multiply(real1, real2), calculator.multiply(imag1, imag2)), denominator);
        double imag = calculator.divide(
                calculator.subtract(calculator.multiply(imag1, real2), calculator.multiply(real1, imag2)), denominator);
        return formatComplexNumber(real, imag);
    }

    // Additional operations on complex numbers

    /**
     * Calculates the magnitude (absolute value) of a complex number.
     *
     * @param real the real part of the complex number
     * @param imag the imaginary part of the complex number
     * @return the magnitude of the complex number
     */
    public double magnitude(double real, double imag) {
        return Math.sqrt(calculator.add(calculator.multiply(real, real), calculator.multiply(imag, imag)));
    }

    /**
     * Calculates the phase (angle) of a complex number in degrees.
     *
     * @param real the real part of the complex number
     * @param imag the imaginary part of the complex number
     * @return the phase (angle) of the complex number in degrees
     */
    public double phase(double real, double imag) {
        return Math.toDegrees(Math.atan2(imag, real));
    }

    /**
     * Returns the conjugate of a complex number.
     * The conjugate of a complex number is obtained by changing the sign of the imaginary part.
     *
     * @param real the real part of the complex number
     * @param imag the imaginary part of the complex number
     * @return a string representation of the conjugate of the complex number
     */
    public String conjugate(double real, double imag) {
        return formatComplexNumber(real, -imag);
    }

    // Helper method to format complex numbers as strings
    /**
     * Formats a complex number as a string in the form "a + bi" or "a - bi".
     *
     * @param real the real part of the complex number
     * @param imag the imaginary part of the complex number
     * @return a string representation of the complex number
     */
    private String formatComplexNumber(double real, double imag) {
        return imag >= 0 ? real + " + " + imag + "i" : real + " - " + Math.abs(imag) + "i";
    }
}
