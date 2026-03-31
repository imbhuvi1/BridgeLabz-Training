
import java.util.Scanner;

public class PalindromeCheck {

    //Iterative Method
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //Logic 2: Recursive Method
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    //Using Character Arrays
    public static char[] reverseString(String text) {
        int length = text.length();
        char[] reverse = new char[length];

        for (int i = 0; i < length; i++) {
            reverse[i] = text.charAt(length - 1 - i);
        }
        return reverse;
    }

    public static boolean isPalindromeUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String input = sc.nextLine();

        System.out.println("\nPalindrome Check Results:");
        System.out.println("Logic 1 (Iterative): " + isPalindromeIterative(input));
        System.out.println("Logic 2 (Recursive): " +isPalindromeRecursive(input, 0, input.length() - 1));
        System.out.println("Logic 3 (Character Array): " +isPalindromeUsingArray(input));

        sc.close();
    }
}


