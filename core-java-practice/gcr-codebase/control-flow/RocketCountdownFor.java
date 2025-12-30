package gcr_codebase.control_flow;

import java.util.Scanner;

public class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for countdown
        System.out.print("Enter countdown start number: ");
        int counter = sc.nextInt();

        // Countdown using for loop
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        sc.close();
    }
}
