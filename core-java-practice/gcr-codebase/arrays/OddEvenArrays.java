package gcr_codebase.arrays;

import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        //taking input
        System.out.print("Enter a natural number: ");

        if (!sc.hasNextInt()) {
            System.err.println("Invalid input!");
            System.exit(0);
        }

        int number = sc.nextInt();
        
        //check whether natural or not
        if (number <= 0) {
            System.err.println("Not a natural number!");
            System.exit(0);
        }

        int[] even = new int[number / 2 + 1];
        int[] odd = new int[number / 2 + 1];

        int evenIndex = 0, oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex++] = i;
            } else {
                odd[oddIndex++] = i;
            }
        }

        System.out.println("Odd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        System.out.println("\nEven Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }

        sc.close();
    }
}
