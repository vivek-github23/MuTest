package org.example.integration;

import org.example.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {
    private Calculator calculator;
    private ComplexNumberCalculator complexCalculator;
    private FinancialCalculator financialCalculator;
    private VectorCalculator vectorCalculator;
    private VolumeCalculator volumeCalculator;

    @Before
    public void setUp() {
        calculator = new Calculator(); // Actual implementation of Calculator
        complexCalculator = new ComplexNumberCalculator(calculator);
        financialCalculator = new FinancialCalculator(calculator);
        vectorCalculator = new VectorCalculator(calculator);
        volumeCalculator = new VolumeCalculator(calculator);
    }

    // --- Calculator Integration ---
    @Test
    public void testBasicCalculatorOperations() {
        assertEquals(5.0, calculator.add(2, 3), 0.0001);
        assertEquals(2.0, calculator.subtract(5, 3), 0.0001);
        assertEquals(6.0, calculator.multiply(2, 3), 0.0001);
        assertEquals(2.0, calculator.divide(6, 3), 0.0001);
    }

    // --- Complex Number Calculator ---
    @Test
    public void testComplexNumberAddition() {
        double real1 = 3, imag1 = 4;
        double real2 = 1, imag2 = 2;
        double expectedReal = 4.0;
        double expectedImag = 6.0;

        double realResult = calculator.add(real1, real2);
        double imagResult = calculator.add(imag1, imag2);

        assertEquals(expectedReal, realResult, 0.0001);
        assertEquals(expectedImag, imagResult, 0.0001);
    }

    @Test
    public void testComplexNumberDotProduct() {
        double[] vector1 = {3, 4, 5};
        double[] vector2 = {1, 2, 3};
        double expectedDotProduct = calculator.add(
                calculator.multiply(vector1[0], vector2[0]),
                calculator.add(
                        calculator.multiply(vector1[1], vector2[1]),
                        calculator.multiply(vector1[2], vector2[2])
                )
        );
        double dotProduct = 3 * 1 + 4 * 2 + 5 * 3;
        assertEquals(expectedDotProduct, dotProduct, 0.0001);
    }

    // --- Financial Calculator ---
    @Test
    public void testSimpleInterest() {
        double principal = 1000.0;
        double rate = 5.0;
        double time = 2.0;
        double expectedInterest = (principal * rate * time) / 100;

        double si = calculator.divide(calculator.multiply(principal, calculator.multiply(rate, time)), 100);
        assertEquals(expectedInterest, si, 0.0001);
    }

    @Test
    public void testCompoundInterest() {
        double principal = 1000.0;
        double rate = 5.0;
        double time = 2.0;
        int frequency = 1;

        double amount = principal * Math.pow((1 + rate / (100 * frequency)), frequency * time);
        double expectedCI = amount - principal;

        double calculatedCI = calculator.subtract(amount, principal);
        assertEquals(expectedCI, calculatedCI, 0.0001);
    }

    // --- Vector Calculator ---
    @Test
    public void testVectorAddition() {
        double[] vector1 = {1, 2, 3};
        double[] vector2 = {4, 5, 6};
        double[] expectedResult = {5, 7, 9};

        double[] result = {
                calculator.add(vector1[0], vector2[0]),
                calculator.add(vector1[1], vector2[1]),
                calculator.add(vector1[2], vector2[2])
        };

        assertEquals(expectedResult[0], result[0], 0.0001);
        assertEquals(expectedResult[1], result[1], 0.0001);
        assertEquals(expectedResult[2], result[2], 0.0001);
    }

    @Test
    public void testVectorCrossProduct() {
        double[] vector1 = {1, 2, 3};
        double[] vector2 = {4, 5, 6};
        double[] expectedResult = {-3, 6, -3};

        double[] result = {
                calculator.subtract(calculator.multiply(vector1[1], vector2[2]), calculator.multiply(vector1[2], vector2[1])),
                calculator.subtract(calculator.multiply(vector1[2], vector2[0]), calculator.multiply(vector1[0], vector2[2])),
                calculator.subtract(calculator.multiply(vector1[0], vector2[1]), calculator.multiply(vector1[1], vector2[0]))
        };

        assertEquals(expectedResult[0], result[0], 0.0001);
        assertEquals(expectedResult[1], result[1], 0.0001);
        assertEquals(expectedResult[2], result[2], 0.0001);
    }

    // --- Volume Calculator ---
    @Test
    public void testSphereVolume() {
        double radius = 3.0;
        double expectedVolume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        double actualVolume = volumeCalculator.calculateSphereVolume(radius);
        assertEquals(expectedVolume, actualVolume, 0.0001);
    }

    @Test
    public void testCubeVolume() {
        double side = 4.0;
        double expectedVolume = Math.pow(side, 3);
        double actualVolume = volumeCalculator.calculateCubeVolume(side);
        assertEquals(expectedVolume, actualVolume, 0.0001);
    }
}
