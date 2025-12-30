package gcr_codebase.control_flow;

import java.util.Scanner;

public class NaturalSumForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        // Check whether number is natural
        if (n > 0) {

            // Sum using formula
            int formulaSum = n * (n + 1) / 2;

            // Sum using for loop
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            // Printing both results
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);

            // Comparing the results
            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("Results are not matching.");
            }

        } else {
            System.out.println("The number is not a natural number.");
        }

        sc.close();
    }
}

