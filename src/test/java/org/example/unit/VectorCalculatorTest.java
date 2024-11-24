package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class VectorCalculatorTest {
    private Calculator calculator;
    private VectorCalculator vectorCalculator;

    @Before
    public void setUp() {
        calculator = new Calculator(); // Assume a functional Calculator implementation
        vectorCalculator = new VectorCalculator(calculator);
    }

    @Test
    public void testVectorAddition() {
        double[] result = vectorCalculator.vectorAddition(new double[]{1, 2, 3}, new double[]{4, 5, 6});
        assertArrayEquals(new double[]{5, 7, 9}, result, 0.0001);
    }

    @Test
    public void testVectorSubtraction() {
        double[] result = vectorCalculator.vectorSubtraction(new double[]{4, 5, 6}, new double[]{1, 2, 3});
        assertArrayEquals(new double[]{3, 3, 3}, result, 0.0001);
    }

    @Test
    public void testDotProduct() {
        double result = vectorCalculator.dotProduct(new double[]{1, 2, 3}, new double[]{4, 5, 6});
        assertEquals(32, result, 0.0001);
    }

    @Test
    public void testCrossProduct() {
        double[] result = vectorCalculator.crossProduct(new double[]{1, 2, 3}, new double[]{4, 5, 6});
        assertArrayEquals(new double[]{-3, 6, -3}, result, 0.0001);
    }

    @Test
    public void testMagnitude() {
        double result = vectorCalculator.magnitude(new double[]{1, 2, 3});
        assertEquals(3.7417, result, 0.0001);
    }

    @Test
    public void testAngleBetweenVectors() {
        double result = vectorCalculator.angleBetweenVectors(new double[]{1, 0, 0}, new double[]{0, 1, 0});
        assertEquals(90, result, 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testAngleWithZeroMagnitudeVector() {
        vectorCalculator.angleBetweenVectors(new double[]{0, 0, 0}, new double[]{1, 1, 1});
    }
}
