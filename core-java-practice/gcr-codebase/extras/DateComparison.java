
import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input first date
        System.out.println("Enter First Date:");
        System.out.print("Year: ");
        int y1 = sc.nextInt();
        System.out.print("Month: ");
        int m1 = sc.nextInt();
        System.out.print("Day: ");
        int d1 = sc.nextInt();

        // Input second date
        System.out.println("\nEnter Second Date:");
        System.out.print("Year: ");
        int y2 = sc.nextInt();
        System.out.print("Month: ");
        int m2 = sc.nextInt();
        System.out.print("Day: ");
        int d2 = sc.nextInt();

        // Create LocalDate objects
        LocalDate date1 = LocalDate.of(y1, m1, d1);
        LocalDate date2 = LocalDate.of(y2, m2, d2);

        // Compare dates
        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE second date");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER second date");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are SAME");
        }

        sc.close();
    }
}
