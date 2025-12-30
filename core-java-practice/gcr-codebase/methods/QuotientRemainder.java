
import java.util.*;

public class QuotientRemainder {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //taking input
        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        //calling method
        int[] result = findRemainderAndQuotient(number, divisor);

        //displaying result
        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);

        sc.close();
    }
}
