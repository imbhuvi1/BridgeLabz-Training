package gcr_codebase.control_flow;

import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Check for natural number
        if (number > 0) {
            int factorial = 1;
            int i = 1;

            // Calculating factorial using while loop
            while (i <= number) {
                factorial *= i;
                i++;
            }

            System.out.println("Factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer.");
        }

        sc.close();
    }
}
