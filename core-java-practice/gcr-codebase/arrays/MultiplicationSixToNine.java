
import java.util.Scanner;

public class MultiplicationSixToNine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        if (!sc.hasNextInt()) {
            System.err.println("Invalid input!");
            System.exit(0);
        }

        int number = sc.nextInt();
        int[] multiplicationResult = new int[4];

        int index = 0;
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[index++] = number * i;
        }

        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[index++]);
        }

        sc.close();
    }
}

