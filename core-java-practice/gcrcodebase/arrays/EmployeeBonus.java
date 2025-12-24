package gcrcodebase.arrays;
import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        // Input loop
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            if (!sc.hasNextDouble()) {
                System.err.println("Invalid salary!");
                sc.next(); // clear input
                i--;       // retry same index
                continue;
            }
            salary[i] = sc.nextDouble();

            System.out.print("Enter years of service: ");
            if (!sc.hasNextDouble()) {
                System.err.println("Invalid years!");
                sc.next();
                i--;
                continue;
            }
            years[i] = sc.nextDouble();
        }

        // Bonus calculation loop
        for (int i = 0; i < 10; i++) {
            if (years[i] > 5)
                bonus[i] = salary[i] * 0.05;
            else
                bonus[i] = salary[i] * 0.02;

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\nTotal Old Salary = " + totalOldSalary);
        System.out.println("Total Bonus Paid = " + totalBonus);
        System.out.println("Total New Salary = " + totalNewSalary);

        sc.close();
    }
}
