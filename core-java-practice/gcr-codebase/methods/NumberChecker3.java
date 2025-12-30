
import java.util.*;

public class NumberChecker3 {

    //method to count number of digits
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    //method to store digits of the number into an array
    public static int[] getDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    //method to reverse the digits array
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    //method to compare two arrays and check if they are equal
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    //method to check whether the number is palindrome using digits array
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    //method to check whether the number is a duck number
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //taking input
        System.out.print("enter a number: ");
        int number = sc.nextInt();

        int[] digits = getDigits(number);
        int[] reversed = reverseArray(digits);

        System.out.println("digits          : " + Arrays.toString(digits));
        System.out.println("reversed digits : " + Arrays.toString(reversed));

        System.out.println("arrays equal    : " + compareArrays(digits, reversed));
        System.out.println("palindrome      : " + isPalindrome(digits));
        System.out.println("duck number     : " + isDuckNumber(digits));

        sc.close();
    }
}
