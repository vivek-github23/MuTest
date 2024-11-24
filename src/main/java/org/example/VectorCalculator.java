package org.example;

public class VectorCalculator {
    private final Calculator calculator;

    public VectorCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public double[] vectorAddition(double[] vector1, double[] vector2) {
        return new double[]{
                calculator.add(vector1[0], vector2[0]),
                calculator.add(vector1[1], vector2[1]),
                calculator.add(vector1[2], vector2[2])
        };
    }

    public double[] vectorSubtraction(double[] vector1, double[] vector2) {
        return new double[]{
                calculator.subtract(vector1[0], vector2[0]),
                calculator.subtract(vector1[1], vector2[1]),
                calculator.subtract(vector1[2], vector2[2])
        };
    }

    public double dotProduct(double[] vector1, double[] vector2) {
        return calculator.add(
                calculator.multiply(vector1[0], vector2[0]),
                calculator.add(
                        calculator.multiply(vector1[1], vector2[1]),
                        calculator.multiply(vector1[2], vector2[2])
                )
        );
    }

    public double[] crossProduct(double[] vector1, double[] vector2) {
        return new double[]{
                calculator.subtract(calculator.multiply(vector1[1], vector2[2]), calculator.multiply(vector1[2], vector2[1])),
                calculator.subtract(calculator.multiply(vector1[2], vector2[0]), calculator.multiply(vector1[0], vector2[2])),
                calculator.subtract(calculator.multiply(vector1[0], vector2[1]), calculator.multiply(vector1[1], vector2[0]))
        };
    }

    public double magnitude(double[] vector) {
        return Math.sqrt(
                calculator.add(
                        calculator.add(
                                calculator.multiply(vector[0], vector[0]),
                                calculator.multiply(vector[1], vector[1])
                        ),
                        calculator.multiply(vector[2], vector[2])
                )
        );
    }

    public double angleBetweenVectors(double[] vector1, double[] vector2) {
        double dotProduct = dotProduct(vector1, vector2);
        double magnitude1 = magnitude(vector1);
        double magnitude2 = magnitude(vector2);

        if (magnitude1 == 0 || magnitude2 == 0) {
            throw new ArithmeticException("Cannot calculate angle with zero-magnitude vector.");
        }

        return Math.toDegrees(Math.acos(dotProduct / (magnitude1 * magnitude2)));
    }
}
