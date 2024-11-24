package org.example;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create instances of the calculators
        Calculator calculator = new Calculator();
        ComplexNumberCalculator complexNumberCalculator = new ComplexNumberCalculator(calculator);
        FinancialCalculator financialCalculator = new FinancialCalculator(calculator);
        VectorCalculator vectorCalculator = new VectorCalculator(calculator);
        VolumeCalculator volumeCalculator = new VolumeCalculator(calculator);

        int choice;

        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Calculator Operations");
            System.out.println("2. Complex Number Operations");
            System.out.println("3. Financial Calculations");
            System.out.println("4. Vector Calculations");
            System.out.println("5. Volume Calculations");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    handleCalculatorOperations(calculator);
                }
                case 2 -> {
                    handleComplexNumberOperations(complexNumberCalculator);
                }
                case 3 -> {
                    handleFinancialOperations(financialCalculator);
                }
                case 4 -> {
                    handleVectorOperations(vectorCalculator);
                }
                case 5 -> {
                    handleVolumeOperations(volumeCalculator);
                }
                case 6 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (true);
    }

    // Handle operations for basic calculator
    private static void handleCalculatorOperations(Calculator calculator) {
        System.out.println("\n--- Calculator Operations ---");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Go Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 5) return;

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        switch (choice) {
            case 1 -> System.out.println("Result: " + calculator.add(num1, num2));
            case 2 -> System.out.println("Result: " + calculator.subtract(num1, num2));
            case 3 -> System.out.println("Result: " + calculator.multiply(num1, num2));
            case 4 -> System.out.println("Result: " + calculator.divide(num1, num2));
            default -> System.out.println("Invalid choice!");
        }
    }

    // Handle operations for complex number calculations
    private static void handleComplexNumberOperations(ComplexNumberCalculator complexNumberCalculator) {
        System.out.println("\n--- Complex Number Calculation Menu ---");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Magnitude");
        System.out.println("6. Phase");
        System.out.println("7. Conjugate");
        System.out.println("8. Go Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 8) return;

        System.out.print("Enter the real and imaginary parts of Complex Number 1: ");
        double real1 = scanner.nextDouble();
        double imag1 = scanner.nextDouble();

        double real2 = 0, imag2 = 0;
        if (choice >= 1 && choice <= 4) {
            System.out.print("Enter the real and imaginary parts of Complex Number 2: ");
            real2 = scanner.nextDouble();
            imag2 = scanner.nextDouble();
        }

        switch (choice) {
            case 1 -> complexNumberCalculator.add(real1, imag1, real2, imag2);
            case 2 -> complexNumberCalculator.subtract(real1, imag1, real2, imag2);
            case 3 -> complexNumberCalculator.multiply(real1, imag1, real2, imag2);
            case 4 -> complexNumberCalculator.divide(real1, imag1, real2, imag2);
            case 5 -> complexNumberCalculator.magnitude(real1, imag1);
            case 6 -> complexNumberCalculator.phase(real1, imag1);
            case 7 -> complexNumberCalculator.conjugate(real1, imag1);
            default -> System.out.println("Invalid choice!");
        }
    }

    // Handle operations for financial calculations
    private static void handleFinancialOperations(FinancialCalculator financialCalculator) {
        System.out.println("\n--- Financial Calculation Menu ---");
        System.out.println("1. Simple Interest");
        System.out.println("2. Compound Interest");
        System.out.println("3. EMI Calculation");
        System.out.println("4. Go Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 4) return;

        System.out.print("Enter Principal Amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter Rate of Interest: ");
        double rate = scanner.nextDouble();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Time (in years): ");
                double time = scanner.nextDouble();
                financialCalculator.calculateSimpleInterest(principal, rate, time);
            }
            case 2 -> {
                System.out.print("Enter Time (in years): ");
                double time = scanner.nextDouble();
                System.out.print("Enter Compounding Frequency: ");
                int frequency = scanner.nextInt();
                financialCalculator.calculateCompoundInterest(principal, rate, time, frequency);
            }
            case 3 -> {
                System.out.print("Enter Time Period (in months): ");
                int months = scanner.nextInt();
                financialCalculator.calculateEMI(principal, rate, months);
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    // Handle operations for vector calculations
    private static void handleVectorOperations(VectorCalculator vectorCalculator) {
        System.out.println("\n--- Vector Calculation Menu ---");
        System.out.println("1. Vector Addition");
        System.out.println("2. Vector Subtraction");
        System.out.println("3. Dot Product");
        System.out.println("4. Cross Product");
        System.out.println("5. Magnitude");
        System.out.println("6. Angle Between Vectors");
        System.out.println("7. Go Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 7) return;

        double[] vector1 = null;

        System.out.print("Enter components of Vector 1 (x y z): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double z1 = scanner.nextDouble();

        vector1 = new double[]{x1,y1,z1};

        double[] vector2 = null;

        if (choice != 5) {
            System.out.print("Enter components of Vector 2 (x y z): ");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double z2 = scanner.nextDouble();
            vector2 = new double[]{x2, y2, z2};
        }

        switch (choice) {
            case 1 -> vectorCalculator.vectorAddition(vector1,vector2);
            case 2 -> vectorCalculator.vectorSubtraction(vector1, vector2);
            case 3 -> vectorCalculator.dotProduct(vector1, vector2);
            case 4 -> vectorCalculator.crossProduct(vector2, vector2);
            case 5 -> vectorCalculator.magnitude(vector1);
            case 6 -> vectorCalculator.angleBetweenVectors(vector1, vector2);
            default -> System.out.println("Invalid choice!");
        }
    }

    // Handle operations for volume calculations
    private static void handleVolumeOperations(VolumeCalculator volumeCalculator) {
        System.out.println("\n--- Volume Calculation Menu ---");
        System.out.println("1. Sphere");
        System.out.println("2. Cube");
        System.out.println("3. Cylinder");
        System.out.println("4. Rectangular Prism");
        System.out.println("5. Go Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 5) return;

        switch (choice) {
            case 1 -> {
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                volumeCalculator.calculateSphereVolume(radius);
            }
            case 2 -> {
                System.out.print("Enter side length: ");
                double side = scanner.nextDouble();
                volumeCalculator.calculateCubeVolume(side);
            }
            case 3 -> {
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                System.out.print("Enter height: ");
                double height = scanner.nextDouble();
                volumeCalculator.calculateCylinderVolume(radius, height);
            }
            case 4 -> {
                System.out.print("Enter length: ");
                double length = scanner.nextDouble();
                System.out.print("Enter width: ");
                double width = scanner.nextDouble();
                System.out.print("Enter height: ");
                double height = scanner.nextDouble();
                volumeCalculator.calculateRectangularPrismVolume(length, width, height);
            }
            default -> System.out.println("Invalid choice!");
        }
    }
}
