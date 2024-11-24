package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.0001);
    }

    @Test
    public void testSubtraction() {
        assertEquals(1.0, calculator.subtract(5.0, 4.0), 0.0001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(20.0, calculator.multiply(5.0, 4.0), 0.0001);
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.divide(10.0, 5.0), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.divide(10.0, 0);
    }

    @Test
    public void testExponent() {
        assertEquals(8.0, calculator.exponent(2.0, 3.0), 0.0001);
    }

    @Test
    public void testLogarithm() {
        assertEquals(1.0, calculator.logarithm(Math.E), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testLogarithmOfNonPositiveNumber() {
        calculator.logarithm(-1.0);
    }

    @Test
    public void testSine() {
        assertEquals(0.5, calculator.sine(30.0), 0.0001);
    }

    @Test
    public void testCosine() {
        assertEquals(0.8660, calculator.cosine(30.0), 0.0001);
    }

    @Test
    public void testTangent() {
        assertEquals(1.0, calculator.tangent(45.0), 0.0001);
    }
}
