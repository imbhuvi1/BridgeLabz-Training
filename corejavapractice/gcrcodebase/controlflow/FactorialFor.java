package gcrcodebase.controlflow;

import java.util.Scanner;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        // Check for natural number
        if (number > 0) {
            int factorial = 1;

            // Calculating factorial using for loop
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println("Factorial of " + number + " is " + factorial);
        } else {
            System.out.println("The number is not a natural number.");
        }

        sc.close();
    }
}
