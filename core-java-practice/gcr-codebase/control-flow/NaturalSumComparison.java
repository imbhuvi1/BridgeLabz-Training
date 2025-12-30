package gcr_codebase.control_flow;

import java.util.Scanner;

public class NaturalSumComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n > 0) {
            // Using formula
            int formulaSum = n * (n + 1) / 2;

            // Using while loop
            int loopSum = 0;
            int i = 1;

            while (i <= n) {
                loopSum += i;
                i++;
            }

            // Displaying both results
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);

            // Comparing results
            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a mismatch in results.");
            }
        } else {
            System.out.println("The number is not a natural number.");
        }

        sc.close();
    }
}
