package gcr_codebase.strings;

import java.util.Scanner;

public class TrimSpacesUsingCharAt {

    // Method to find start and end index after trimming spaces
    static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;
        
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
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

        // Taking input
        System.out.print("Enter text with spaces: ");
        String input = sc.nextLine();

        // User-defined trim logic
        int[] indexes = findTrimIndexes(input);
        String customTrim = createSubstring(input, indexes[0], indexes[1]);

        // Built-in trim
        String builtInTrim = input.trim();

        // Compare results
        boolean isSame = compareStrings(customTrim, builtInTrim);

        // Display results
        System.out.println("\nAfter trimming (User-defined): \"" + customTrim + "\"");
        System.out.println("After trimming (Built-in):     \"" + builtInTrim + "\"");
        System.out.println("Are both results same? " + isSame);

        sc.close();
    }
}


