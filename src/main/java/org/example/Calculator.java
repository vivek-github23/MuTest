package org.example;

public class Calculator {

    // Basic Operations
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public double exponent(double base, double power) {
        return Math.pow(base, power);
    }

    public double logarithm(double value) {
        if (value <= 0) {
            throw new ArithmeticException("Logarithm of non-positive numbers is undefined.");
        }
        return Math.log(value);
    }

    public double sine(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public double cosine(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public double tangent(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
}
