package gcr_codebase.control_flow;

import java.util.Scanner;
public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //initializing variables to store total value 0.0 and in value the user will enter
        double total = 0.0;
        double value;

        // Loop continues until user enters 0
        while (true) {
            System.out.print("Enter a number (0 to stop): ");
            value = sc.nextDouble();

            if (value == 0) {
                break;
            }

            total += value;
        }

        System.out.println("Total sum is: " + total);
        sc.close();
    }
}
