package gcr_codebase.methods;

import java.util.*;

public class FactorCheck {

    //Method to find all factors of a number and return an array
    public static int[] getFactors(int number) {

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];

        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    //Method to find the greatest factor
    public static int greatestFactor(int[] factors) {
        int greatest = factors[0];
        for (int f : factors) {
            if (f > greatest) {
                greatest = f;
            }
        }
        return greatest;
    }

    //Method to find the sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    //Method to find the product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    //Method to find the product of cube of factors using Math.pow()
    public static double productOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }

    // main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //taking input
        System.out.print("enter a number: ");
        int number = sc.nextInt();

        int[] factors = getFactors(number);

        System.out.println("factors            : " + Arrays.toString(factors));
        System.out.println("greatest factor    : " + greatestFactor(factors));
        System.out.println("sum of factors     : " + sumOfFactors(factors));
        System.out.println("product of factors : " + productOfFactors(factors));
        System.out.println("product of cubes   : " + productOfCubeOfFactors(factors));

        sc.close();
    }
}
