
import java.util.*;

public class CalculateSimpleInterest {

    // Method to calculate Simple Interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        //Taking user input
        System.out.print("Enter Principal Amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time: ");
        double time = sc.nextDouble();

        double simpleInterest = calculateSimpleInterest(principal, rate, time);
        
        System.out.printf("The Simple Interest is %s for Principal %s, Rate of Interest and Time %s",simpleInterest, principal, rate, time);

        sc.close();
    }
}

