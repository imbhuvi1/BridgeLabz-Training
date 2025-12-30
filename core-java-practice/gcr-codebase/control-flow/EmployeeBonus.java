
import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking salary input
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        // Taking years of service
        System.out.print("Enter years of service: ");
        int years = sc.nextInt();

        // Checking bonus eligibility
        if (years > 5) {
            double bonus = salary * 0.05;
            System.out.println("Bonus amount is: " + bonus);
        } else {
            System.out.println("No bonus applicable.");
        }

        sc.close();
    }
}
 
