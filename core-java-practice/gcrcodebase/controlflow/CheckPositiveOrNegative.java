package gcrcodebase.controlflow;

import java.util.Scanner;
public class CheckPositiveOrNegative {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Taking number input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Checking number type
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }

        sc.close();
	}

}
