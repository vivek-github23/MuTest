package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VolumeCalculatorTest {
    private Calculator calculator;
    private VolumeCalculator volumeCalculator;

    @Before
    public void setUp() {
        calculator = new Calculator(); // Replace with actual Calculator implementation
        volumeCalculator = new VolumeCalculator(calculator);
    }

    @Test
    public void testCalculateSphereVolume() {
        double radius = 3.0;
        double expectedVolume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        double actualVolume = volumeCalculator.calculateSphereVolume(radius);
        assertEquals(expectedVolume, actualVolume, 0.0001);
    }

    @Test
    public void testCalculateCubeVolume() {
        double side = 4.0;
        double expectedVolume = Math.pow(side, 3);
        double actualVolume = volumeCalculator.calculateCubeVolume(side);
        assertEquals(expectedVolume, actualVolume, 0.0001);
    }

    @Test
    public void testCalculateCylinderVolume() {
        double radius = 2.0;
        double height = 5.0;
        double expectedVolume = Math.PI * Math.pow(radius, 2) * height;
        double actualVolume = volumeCalculator.calculateCylinderVolume(radius, height);
        assertEquals(expectedVolume, actualVolume, 0.0001);
    }

    @Test
    public void testCalculateRectangularPrismVolume() {
        double length = 2.0;
        double width = 3.0;
        double height = 4.0;
        double expectedVolume = length * width * height;
        double actualVolume = volumeCalculator.calculateRectangularPrismVolume(length, width, height);
        assertEquals(expectedVolume, actualVolume, 0.0001);
    }
}
