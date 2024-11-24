package org.example;

/**
 * A class that provides vector operations such as addition, subtraction, dot product, cross product, magnitude,
 * and the angle between two vectors.
 */
public class VectorCalculator {
    private final Calculator calculator;

    /**
     * Constructor to initialize the VectorCalculator with a Calculator instance.
     *
     * @param calculator an instance of the Calculator class to perform basic operations
     */
    public VectorCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    // Vector operations

    /**
     * Performs vector addition of two 3D vectors.
     *
     * Vector addition is performed component-wise:
     * Result = (x1 + x2, y1 + y2, z1 + z2)
     *
     * @param vector1 the first 3D vector
     * @param vector2 the second 3D vector
     * @return the resulting 3D vector after addition
     */
    public double[] vectorAddition(double[] vector1, double[] vector2) {
        return new double[]{
                calculator.add(vector1[0], vector2[0]),
                calculator.add(vector1[1], vector2[1]),
                calculator.add(vector1[2], vector2[2])
        };
    }

    /**
     * Performs vector subtraction of two 3D vectors.
     *
     * Vector subtraction is performed component-wise:
     * Result = (x1 - x2, y1 - y2, z1 - z2)
     *
     * @param vector1 the first 3D vector
     * @param vector2 the second 3D vector
     * @return the resulting 3D vector after subtraction
     */
    public double[] vectorSubtraction(double[] vector1, double[] vector2) {
        return new double[]{
                calculator.subtract(vector1[0], vector2[0]),
                calculator.subtract(vector1[1], vector2[1]),
                calculator.subtract(vector1[2], vector2[2])
        };
    }

    /**
     * Calculates the dot product of two 3D vectors.
     *
     * Dot Product formula:
     * A·B = x1*x2 + y1*y2 + z1*z2
     *
     * @param vector1 the first 3D vector
     * @param vector2 the second 3D vector
     * @return the dot product of the two vectors
     */
    public double dotProduct(double[] vector1, double[] vector2) {
        return calculator.add(
                calculator.multiply(vector1[0], vector2[0]),
                calculator.add(
                        calculator.multiply(vector1[1], vector2[1]),
                        calculator.multiply(vector1[2], vector2[2])
                )
        );
    }

    /**
     * Calculates the cross product of two 3D vectors.
     *
     * Cross Product formula:
     * A × B = (y1*z2 - z1*y2, z1*x2 - x1*z2, x1*y2 - y1*x2)
     *
     * @param vector1 the first 3D vector
     * @param vector2 the second 3D vector
     * @return the resulting 3D vector after the cross product
     */
    public double[] crossProduct(double[] vector1, double[] vector2) {
        return new double[]{
                calculator.subtract(calculator.multiply(vector1[1], vector2[2]), calculator.multiply(vector1[2], vector2[1])),
                calculator.subtract(calculator.multiply(vector1[2], vector2[0]), calculator.multiply(vector1[0], vector2[2])),
                calculator.subtract(calculator.multiply(vector1[0], vector2[1]), calculator.multiply(vector1[1], vector2[0]))
        };
    }

    /**
     * Calculates the magnitude (length) of a 3D vector.
     *
     * Magnitude formula:
     * ||A|| = √(x² + y² + z²)
     *
     * @param vector the 3D vector whose magnitude is to be calculated
     * @return the magnitude of the vector
     */
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

    /**
     * Calculates the angle between two vectors in degrees.
     *
     * Angle formula:
     * θ = cos⁻¹((A·B) / (||A|| * ||B||))
     * where A·B is the dot product and ||A||, ||B|| are the magnitudes of vectors A and B respectively.
     *
     * @param vector1 the first 3D vector
     * @param vector2 the second 3D vector
     * @return the angle between the two vectors in degrees
     * @throws ArithmeticException if any of the vectors has zero magnitude
     */
    public double angleBetweenVectors(double[] vector1, double[] vector2) {
        // Calculate dot product and magnitudes of both vectors
        double dotProduct = dotProduct(vector1, vector2);
        double magnitude1 = magnitude(vector1);
        double magnitude2 = magnitude(vector2);

        // If either of the vectors has zero magnitude, angle calculation is not possible
        if (magnitude1 == 0 || magnitude2 == 0) {
            throw new ArithmeticException("Cannot calculate angle with zero-magnitude vector.");
        }

        // Calculate and return the angle in degrees
        return Math.toDegrees(Math.acos(dotProduct / (magnitude1 * magnitude2)));
    }
}
