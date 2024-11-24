package org.example;

/**
 * A class that provides financial calculations such as simple interest, compound interest, and EMI.
 */
public class FinancialCalculator {
    private final Calculator calculator;

    /**
     * Constructor to initialize the FinancialCalculator with a Calculator instance.
     *
     * @param calculator an instance of the Calculator class to perform basic operations
     */
    public FinancialCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    // Financial calculations

    /**
     * Calculates simple interest.
     *
     * Simple Interest is calculated using the formula:
     * Simple Interest = (Principal * Rate * Time) / 100
     *
     * @param principal the principal amount
     * @param rate the interest rate (as a percentage)
     * @param time the time period for which the interest is calculated (in years)
     * @return the calculated simple interest
     */
    public double calculateSimpleInterest(double principal, double rate, double time) {
        // Formula: (Principal * Rate * Time) / 100
        return calculator.divide(calculator.multiply(principal, calculator.multiply(rate, time)), 100);
    }

    /**
     * Calculates compound interest.
     *
     * Compound Interest is calculated using the formula:
     * Compound Interest = Principal * (1 + Rate / (100 * Frequency))^(Frequency * Time) - Principal
     *
     * @param principal the principal amount
     * @param rate the annual interest rate (as a percentage)
     * @param time the time period for which the interest is calculated (in years)
     * @param frequency the number of times the interest is compounded per year (e.g., monthly, quarterly)
     * @return the calculated compound interest
     */
    public double calculateCompoundInterest(double principal, double rate, double time, int frequency) {
        // Formula: Principal * (1 + Rate / (100 * Frequency))^(Frequency * Time) - Principal
        double amount = principal * Math.pow((1 + rate / (100 * frequency)), frequency * time);
        return calculator.subtract(amount, principal);
    }

    /**
     * Calculates Equated Monthly Installment (EMI) for a loan.
     *
     * EMI is calculated using the formula:
     * EMI = (P * r * (1 + r)^n) / ((1 + r)^n - 1)
     * where P is the loan amount, r is the monthly interest rate, and n is the number of months.
     *
     * @param principal the loan amount (principal)
     * @param rate the annual interest rate (as a percentage)
     * @param months the number of months over which the loan is repaid
     * @return the calculated EMI amount
     * @throws ArithmeticException if there is an error in EMI calculation (e.g., division by zero)
     */
    public double calculateEMI(double principal, double rate, int months) {
        // Monthly interest rate
        double monthlyRate = rate / (12 * 100);

        // Numerator: P * r * (1 + r)^n
        double numerator = calculator.multiply(principal, monthlyRate * Math.pow(1 + monthlyRate, months));

        // Denominator: (1 + r)^n - 1
        double denominator = Math.pow(1 + monthlyRate, months) - 1;

        // Handle division by zero error
        if (denominator == 0) {
            throw new ArithmeticException("EMI calculation error: denominator is zero.");
        }

        // Return the EMI value: numerator / denominator
        return calculator.divide(numerator, denominator);
    }
}
