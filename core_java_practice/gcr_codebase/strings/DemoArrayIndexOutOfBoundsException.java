package gcr_codebase.strings;

import java.util.Scanner;

public class DemoArrayIndexOutOfBoundsException {

    // Method to generate the exception (no try-catch)
    static void generateException(String[] names) {
    	
        // Accessing index greater than array length
        System.out.println(names[10]);
    }

    // Method to handle ArrayIndexOutOfBoundsException using try-catch
    static void handleException(String[] names) {
        try {
            System.out.println(names[10]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } 
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking array size input
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Declaring array
        String[] names = new String[n];

        // Taking user input for array elements
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        //Generates exception and abruptly stops program if uncommented
        // generateException(names);

        //Handles the runtime exception
        handleException(names);

        sc.close();
    }
}
