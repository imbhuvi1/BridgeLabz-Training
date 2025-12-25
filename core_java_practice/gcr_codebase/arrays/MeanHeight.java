package gcr_codebase.arrays;

import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] heights = new double[11];
        double sum = 0;

        System.out.println("Enter heights of 11 players:");

        for (int i = 0; i < heights.length; i++) {
            if (!sc.hasNextDouble()) {
                System.err.println("Invalid height!");
                System.exit(0);
            }
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }

        double mean = sum / 11;
        System.out.println("Mean Height = " + mean);

        sc.close();
    }
}

