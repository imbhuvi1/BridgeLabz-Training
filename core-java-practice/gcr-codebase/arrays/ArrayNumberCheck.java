import java.util.Scanner;

public class ArrayNumberCheck {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter 5 integers:");

        // Taking user input
        for (int i = 0; i < arr.length; i++) {

            if (!sc.hasNextInt()) {
                System.err.println("Error: Please enter only integer values!");
                System.exit(0);   // Terminates program immediately
            }

            arr[i] = sc.nextInt();
        }

        // Checking numbers
        System.out.println("\nNumber Analysis:");
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0) {
                if (arr[i] % 2 == 0) {
                    System.out.println(arr[i] + " is Positive and Even");
                } else {
                    System.out.println(arr[i] + " is Positive and Odd");
                }
            }
            else if (arr[i] < 0) {
                System.out.println(arr[i] + " is Negative");
            }
            else {
                System.out.println(arr[i] + " is Zero");
            }
        }

        // Comparing first and last elements
        System.out.println("\nComparison of First and Last Element:");

        if (arr[0] == arr[arr.length - 1]) {
            System.out.println("First and Last elements are Equal");
        }
        else if (arr[0] > arr[arr.length - 1]) {
            System.out.println("First element is Greater than Last element");
        }
        else {
            System.out.println("First element is Less than Last element");
        }

        sc.close();
    }
}
