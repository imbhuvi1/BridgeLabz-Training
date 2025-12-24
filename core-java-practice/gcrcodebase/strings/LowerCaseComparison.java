package gcrcodebase.strings;

import java.util.Scanner;

public class LowerCaseComparison {

    // Method to convert string to lowercase using charAt() and ASCII logic
    static String convertToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If character is uppercase (A–Z)
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32); // ASCII difference
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

        // Using built-in toLowerCase()
        String builtInLower = input.toLowerCase();

        // Using user-defined method
        String customLower = convertToLowerCase(input);

        // Comparing both results
        boolean isSame = compareStrings(builtInLower, customLower);

        // Displaying results
        System.out.println("Lowercase using built-in method: " + builtInLower);
        System.out.println("Lowercase using user-defined method: " + customLower);
        System.out.println("Are both results same? " + isSame);

        sc.close();
    }
}
