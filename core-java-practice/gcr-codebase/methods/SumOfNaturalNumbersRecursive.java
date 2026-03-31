
import java.util.Scanner;

public class SumOfNaturalNumbersRecursive {

    public static int sumRecursive(int n) {
        if (n == 0) return 0;
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //input
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        //calling = methof
        int r1 = sumRecursive(n);
        int r2 = sumFormula(n);

        //displaying
        System.out.println("Recursive Sum = " + r1);
        System.out.println("Formula Sum = " + r2);
        System.out.println("Both results are equal: " + (r1 == r2));
        sc.close();
    }
}

