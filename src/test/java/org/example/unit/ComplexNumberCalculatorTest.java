package org.example.unit;

import org.example.Calculator;
import org.example.ComplexNumberCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComplexNumberCalculatorTest {
    private Calculator calculator;
    private ComplexNumberCalculator complexCalculator;

    @Before
    public void setUp() {
        calculator = new Calculator(); // Assume a functional Calculator implementation
        complexCalculator = new ComplexNumberCalculator(calculator);
    }

    @Test
    public void testAddition() {
        String result = complexCalculator.add(2.0, 3.0, 1.0, 4.0);
        assertEquals("3.0 + 7.0i", result);
    }

    @Test
    public void testSubtraction() {
        String result = complexCalculator.subtract(5.0, 6.0, 2.0, 3.0);
        assertEquals("3.0 + 3.0i", result);
    }

    @Test
    public void testMultiplication() {
        String result = complexCalculator.multiply(2.0, 3.0, 1.0, 4.0);
        assertEquals("-10.0 + 11.0i", result);
    }

    @Test
    public void testDivision() {
        String result = complexCalculator.divide(4.0, 2.0, 2.0, -2.0);
        assertEquals("0.5 + 1.5i", result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        complexCalculator.divide(4.0, 2.0, 0.0, 0.0);
    }

    @Test
    public void testMagnitude() {
        double result = complexCalculator.magnitude(3.0, 4.0);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testPhase() {
        double result = complexCalculator.phase(1.0, Math.sqrt(3.0));
        assertEquals(60.0, result, 0.0001);
    }

    @Test
    public void testConjugate() {
        String result = complexCalculator.conjugate(3.0, 4.0);
        assertEquals("3.0 - 4.0i", result);
    }
}
