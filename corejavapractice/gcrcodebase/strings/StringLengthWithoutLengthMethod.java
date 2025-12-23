package gcrcodebase.strings;


import java.util.Scanner;

public class StringLengthWithoutLengthMethod {

    // Method to find string length without using length()
    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } 
        catch (RuntimeException e) {
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input using next()
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Calling user-defined method
        int customLength = findLength(input);

        // Calling built-in length() method
        int builtInLength = input.length();

        // Displaying results
        System.out.println("Length using user-defined method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);

        sc.close();
    }
}
