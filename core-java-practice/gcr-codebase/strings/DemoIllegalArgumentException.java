package gcr_codebase.strings;

import java.util.*;
public class DemoIllegalArgumentException {
	
	// Method to generate the exception
    static void generateException(String str) {
        String result = str.substring(5, 2);
        System.out.println(result);
    }

    // Method to handle IllegalArgumentException using try-catch
    static void handleException(String str) {
        try {
            String result = str.substring(5, 2);
            System.out.println(result);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } 
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // First call: generates exception and stops program if uncommented
        // generateException(input);

        // Second call: handles exception properly
        handleException(input);

        sc.close();
    }
}
