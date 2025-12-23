package gcrcodebase.strings;

import java.util.Scanner;

public class UpperCaseComparison {

    // Method to convert string to uppercase using charAt() and ASCII logic
    static String convertToUpperCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If character is lowercase (a–z)
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32); // ASCII difference
            }

            result = result + ch;
        }
        return result;
    }

    // Method to compare two strings using charAt()
    static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking complete text input
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // Using built-in toUpperCase()
        String builtInUpper = input.toUpperCase();

        // Using user-defined method
        String customUpper = convertToUpperCase(input);

        // Comparing both results
        boolean isSame = compareStrings(builtInUpper, customUpper);

        // Displaying results
        System.out.println("Uppercase using built-in method: " + builtInUpper);
        System.out.println("Uppercase using user-defined method: " + customUpper);
        System.out.println("Are both results same? " + isSame);

        sc.close();
    }
}
