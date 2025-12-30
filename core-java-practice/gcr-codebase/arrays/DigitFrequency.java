package gcr_codebase.arrays;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number, count = 0;

        // Count digits
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        int[] frequency = new int[10];

        // Store digits
        for (int i = 0; i < count; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Frequency calculation
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        // Display
        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0)
                System.out.println(i + " -> " + frequency[i]);
        }

        sc.close();
    }
}
