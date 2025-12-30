
import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int number = sc.nextInt();
        int temp = number;
        int count = 0;

        // Count digits
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        int[] reverse = new int[count];

        // Store digits
        for (int i = 0; i < count; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Reverse array
        for (int i = 0; i < count; i++) {
            reverse[i] = digits[count - 1 - i];
        }

        System.out.println("Reversed Number:");
        for (int i = 0; i < count; i++) {
            System.out.print(reverse[i]);
        }

        sc.close();
    }
}
