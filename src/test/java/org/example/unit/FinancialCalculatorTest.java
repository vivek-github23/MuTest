package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinancialCalculatorTest {
    private Calculator calculator;
    private FinancialCalculator financialCalculator;

    @Before
    public void setUp() {
        calculator = new Calculator(); // Assume a functional Calculator implementation
        financialCalculator = new FinancialCalculator(calculator);
    }

    @Test
    public void testCalculateSimpleInterest() {
        double result = financialCalculator.calculateSimpleInterest(1000, 5, 2);
        assertEquals(100.0, result, 0.0001);
    }

    @Test
    public void testCalculateCompoundInterest() {
        double result = financialCalculator.calculateCompoundInterest(1000, 5, 2, 1); // Annual compounding
        assertEquals(102.5, result, 0.0001);
    }

    @Test
    public void testCalculateEMI() {
        double result = financialCalculator.calculateEMI(100000, 10, 12); // 1 year EMI
        assertEquals(8791.59, result, 0.01);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculateEMIWithZeroDenominator() {
        financialCalculator.calculateEMI(100000, 0, 12); // Invalid EMI calculation
    }
}
