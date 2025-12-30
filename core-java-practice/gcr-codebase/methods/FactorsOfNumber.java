
import java.util.*;

public class FactorsOfNumber {

	//method to find factors
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[index++] = i;
        }
        return factors;
    }

    //method to calculate sum of the factor
    public static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }

    //method to find product of the factors
    public static long product(int[] arr) {
        long p = 1;
        for (int x : arr) p *= x;
        return p;
    }

    //method to find the sum of squares of the factors
    public static double sumOfSquares(int[] arr) {
        double s = 0;
        for (int x : arr) s += Math.pow(x, 2);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //taking input
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        //callling a methods to find factors
        int[] factors = findFactors(n);

        //displaying
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");

        System.out.println("\nSum = " + sum(factors));
        System.out.println("Product = " + product(factors));
        System.out.println("Sum of Squares = " + sumOfSquares(factors));
        sc.close();
    }
}
