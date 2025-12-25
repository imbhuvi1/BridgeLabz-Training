package gcr_codebase.strings;

import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and Status for each person
    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightMeter = heightCm / 100.0;

            double bmi = weight / (heightMeter * heightMeter);

            String status;
            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }
            
            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }

        return result;
    }

    // Method to display the result in tabular format
    public static void displayResult(String[][] result) {
        System.out.println("\nPerson\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");

        for (int i = 0; i < result.length; i++) {
            System.out.println((i + 1) + "\t" +result[i][0] + "\t\t" +result[i][1] + "\t\t" +result[i][2] + "\t" +result[i][3]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] personData = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            personData[i][1] = sc.nextDouble();
        }

        String[][] bmiDetails = calculateBMI(personData);
        displayResult(bmiDetails);

        sc.close();
    }
}

