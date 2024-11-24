package org.example;

public class FinancialCalculator {
    private final Calculator calculator;

    public FinancialCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public double calculateSimpleInterest(double principal, double rate, double time) {
        return calculator.divide(calculator.multiply(principal, calculator.multiply(rate, time)), 100);
    }

    public double calculateCompoundInterest(double principal, double rate, double time, int frequency) {
        double amount = principal * Math.pow((1 + rate / (100 * frequency)), frequency * time);
        return calculator.subtract(amount, principal);
    }

    public double calculateEMI(double principal, double rate, int months) {
        double monthlyRate = rate / (12 * 100);
        double numerator = calculator.multiply(principal, monthlyRate * Math.pow(1 + monthlyRate, months));
        double denominator = Math.pow(1 + monthlyRate, months) - 1;

        if (denominator == 0) {
            throw new ArithmeticException("EMI calculation error: denominator is zero.");
        }
        return calculator.divide(numerator, denominator);
    }
}
