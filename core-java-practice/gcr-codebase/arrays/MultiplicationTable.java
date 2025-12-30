
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer number: ");

        // Input validation
        if (!sc.hasNextInt()) {
            System.err.println("Error: Invalid input! Please enter an integer.");
            System.exit(0);
        }

        int number = sc.nextInt();

        // Define array to store multiplication results.
        int[] table = new int[10];

        // Store results in array
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        // Display multiplication table.
        System.out.println("\nMultiplication Table:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }

        sc.close();
    }
}
