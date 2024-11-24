package org.example;

public class ComplexNumberCalculator {
    private final Calculator calculator;

    public ComplexNumberCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public String add(double real1, double imag1, double real2, double imag2) {
        double real = calculator.add(real1, real2);
        double imag = calculator.add(imag1, imag2);
        return formatComplexNumber(real, imag);
    }

    public String subtract(double real1, double imag1, double real2, double imag2) {
        double real = calculator.subtract(real1, real2);
        double imag = calculator.subtract(imag1, imag2);
        return formatComplexNumber(real, imag);
    }

    public String multiply(double real1, double imag1, double real2, double imag2) {
        double real = calculator.subtract(calculator.multiply(real1, real2), calculator.multiply(imag1, imag2));
        double imag = calculator.add(calculator.multiply(real1, imag2), calculator.multiply(imag1, real2));
        return formatComplexNumber(real, imag);
    }

    public String divide(double real1, double imag1, double real2, double imag2) {
        double denominator = calculator.add(calculator.multiply(real2, real2), calculator.multiply(imag2, imag2));
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero in complex number division.");
        }
        double real = calculator.divide(
                calculator.add(calculator.multiply(real1, real2), calculator.multiply(imag1, imag2)), denominator);
        double imag = calculator.divide(
                calculator.subtract(calculator.multiply(imag1, real2), calculator.multiply(real1, imag2)), denominator);
        return formatComplexNumber(real, imag);
    }

    public double magnitude(double real, double imag) {
        return Math.sqrt(calculator.add(calculator.multiply(real, real), calculator.multiply(imag, imag)));
    }

    public double phase(double real, double imag) {
        return Math.toDegrees(Math.atan2(imag, real));
    }

    public String conjugate(double real, double imag) {
        return formatComplexNumber(real, -imag);
    }

    private String formatComplexNumber(double real, double imag) {
        return imag >= 0 ? real + " + " + imag + "i" : real + " - " + Math.abs(imag) + "i";
    }
}
