
import java.util.*;

public class NumberChecker2 {

    //Method to count digits
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    //Method to store digits in an array
    public static int[] getDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    //Method to find sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    //Method to find sum of squares
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    //Method to check Harshad Number
    public static boolean isHarshad(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    //Method to find digit frequency
    public static int[][] digitFrequency(int[] digits) {

        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
            freq[i][1] = 0;
        }

        for (int d : digits) {
            freq[d][1]++;
        }
        return freq;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //taking input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = getDigits(number);

        System.out.println("Digits              : " + Arrays.toString(digits));
        System.out.println("Digit Count         : " + countDigits(number));
        System.out.println("Sum of Digits       : " + sumOfDigits(digits));
        System.out.println("Sum of Squares      : " + sumOfSquares(digits));
        System.out.println("Harshad Number      : " + isHarshad(number, digits));

        System.out.println("\nDigit Frequency:");
        int[][] freq = digitFrequency(digits);
        System.out.println("Digit  Frequency");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i][1] > 0) {
                System.out.println(freq[i][0] + "      " + freq[i][1]);
            }
        }

        sc.close();
    }
}
