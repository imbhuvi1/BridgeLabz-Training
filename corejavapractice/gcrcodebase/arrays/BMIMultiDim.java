package gcrcodebase.arrays;

import java.util.Scanner;

public class BMIMultiDim {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // 0 → weight, 1 → height, 2 → BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight (kg): ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Enter height (m): ");
            personData[i][1] = sc.nextDouble();

            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.err.println("Enter positive values only!");
                i--;
            }
        }

        // BMI & status
        for (int i = 0; i < number; i++) {
            personData[i][2] =
                personData[i][0] / (personData[i][1] * personData[i][1]);

            if (personData[i][2] <= 18.4)
                weightStatus[i] = "Underweight";
            else if (personData[i][2] <= 24.9)
                weightStatus[i] = "Normal";
            else if (personData[i][2] <= 39.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        // Display
        System.out.println("\nHeight\tWeight\tBMI\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.println(personData[i][1] + "\t" +
                               personData[i][0] + "\t" +
                               String.format("%.2f", personData[i][2]) + "\t" +
                               weightStatus[i]);
        }

        sc.close();
    }
}
