package gcr_codebase.arrays;

import java.util.Scanner;

public class FizzBuzzArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");

        if (!sc.hasNextInt()) {
            System.err.println("Invalid input!");
            System.exit(0);
        }

        int number = sc.nextInt();

        if (number <= 0) {
            System.err.println("Number must be positive!");
            System.exit(0);
        }

        String[] result = new String[number + 1];

        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                result[i] = "FizzBuzz";
            else if (i % 3 == 0)
                result[i] = "Fizz";
            else if (i % 5 == 0)
                result[i] = "Buzz";
            else
                result[i] = String.valueOf(i);
        }

        for (int i = 1; i <= number; i++) {
            System.out.println("Position " + i + " = " + result[i]);
        }

        sc.close();
    }
}

