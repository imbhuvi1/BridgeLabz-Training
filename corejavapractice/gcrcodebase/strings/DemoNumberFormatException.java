package gcrcodebase.strings;

import java.util.Scanner;

public class DemoNumberFormatException {

    // Method to generate the exception (no try-catch)
    static void generateException(String text) {
        // This will throw NumberFormatException if text is not numeric
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    // Method to handle NumberFormatException using try-catch
    static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } 
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } 
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input as String
        System.out.print("Enter a value: ");
        String input = sc.nextLine();

        //Generates exception and abruptly stops program if uncommented
         generateException(input);

        //Handles the runtime exception
//        handleException(input);

        sc.close();
    }
}

