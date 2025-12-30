package gcr_codebase.methods;

import java.util.*;

public class NumberChecker5 {

    //Method to check whether a number is a Perfect number
    public static boolean isPerfect(int number) {
        if (number <= 0)
            return false;

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    //Method to check whether a number is an Abundant number
    public static boolean isAbundant(int number) {
        if (number <= 0)
            return false;

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum > number;
    }

    //Method to check whether a number is a Deficient number
    public static boolean isDeficient(int number) {
        if (number <= 0)
            return false;

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum < number;
    }

    //Method to check whether a number is a Strong number
    public static boolean isStrong(int number) {
        int original = number;
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }
        return sum == original;
    }

    //Method to find factorial of a digit
    public static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }

    // main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //taking user input
        System.out.print("enter a number: ");
        int number = sc.nextInt();

        System.out.println("perfect number  : " + isPerfect(number));
        System.out.println("abundant number : " + isAbundant(number));
        System.out.println("deficient number: " + isDeficient(number));
        System.out.println("strong number   : " + isStrong(number));

        sc.close();
    }
}
