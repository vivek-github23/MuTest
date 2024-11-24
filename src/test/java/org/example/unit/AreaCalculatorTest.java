package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AreaCalculatorTest {
    private Calculator calculator;
    private AreaCalculator areaCalculator;

    @Before
    public void setUp() {
        calculator = new Calculator(); // Assuming Calculator is a simple utility class
        areaCalculator = new AreaCalculator(calculator);
    }

    @Test
    public void testCalculateCircleArea() {
        double radius = 3.0;
        double expectedArea = Math.PI * radius * radius;
        assertEquals(expectedArea, areaCalculator.calculateCircleArea(radius), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateCircleAreaNegativeRadius() {
        areaCalculator.calculateCircleArea(-3.0);
    }

    @Test
    public void testCalculateRectangleArea() {
        double length = 5.0;
        double breadth = 4.0;
        double expectedArea = length * breadth;
        assertEquals(expectedArea, areaCalculator.calculateRectangleArea(length, breadth), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateRectangleAreaNegativeValues() {
        areaCalculator.calculateRectangleArea(-5.0, 4.0);
    }

    @Test
    public void testCalculateTriangleArea() {
        double base = 6.0;
        double height = 3.0;
        double expectedArea = 0.5 * base * height;
        assertEquals(expectedArea, areaCalculator.calculateTriangleArea(base, height), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTriangleAreaNegativeValues() {
        areaCalculator.calculateTriangleArea(6.0, -3.0);
    }

    @Test
    public void testCalculateSquareArea() {
        double side = 4.0;
        double expectedArea = side * side;
        assertEquals(expectedArea, areaCalculator.calculateSquareArea(side), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSquareAreaNegativeSide() {
        areaCalculator.calculateSquareArea(-4.0);
    }
}
