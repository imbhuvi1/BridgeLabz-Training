
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();

        System.out.print("Enter day (1-31): ");
        int d = sc.nextInt();

        System.out.print("Enter year (>= 1582): ");
        int y = sc.nextInt();

        if (y < 1582) {
            System.out.println("Year must be >= 1582.");
            sc.close();
            return;
        }

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        // 0=Sunday, 1=Monday,...,6=Saturday
        System.out.println("Day of week (0=Sunday,...6=Saturday): " + d0);

        sc.close();
    }
}

