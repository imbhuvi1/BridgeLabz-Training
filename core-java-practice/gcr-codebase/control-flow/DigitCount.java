package gcr_codebase.control_flow;

import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = 0;
        int temp = Math.abs(number);  // Handle negative numbers

        if (temp == 0) count = 1;  // 0 has 1 digit

        while (temp != 0) {
            temp /= 10;
            count++;
        }

        System.out.println("Number of digits: " + count);

        sc.close();
    }
}

