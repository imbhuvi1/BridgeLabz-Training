package gcr_codebase.control_flow;

import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (>1): ");
        int number = sc.nextInt();

        if (number <= 1) {
            System.out.println(number + " is NOT a prime number.");
            sc.close();
            return;
        }

        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {  // Only need to check up to sqrt(number)
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is NOT a prime number.");
        }
        sc.close();
    }
}

