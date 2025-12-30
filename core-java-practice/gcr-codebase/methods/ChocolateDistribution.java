
import java.util.*;

public class ChocolateDistribution {

    // Method to find chocolates per child and remaining chocolates
    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        int chocolatesForEach = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        return new int[]{chocolatesForEach, remainingChocolates};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //taking input
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int numberOfChildren = sc.nextInt();

        //calling method
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        //displaying result
        System.out.println("Each child gets " + result[0] + " chocolates");
        System.out.println("Remaining chocolates:  " + result[1]);

        sc.close();
    }
}

