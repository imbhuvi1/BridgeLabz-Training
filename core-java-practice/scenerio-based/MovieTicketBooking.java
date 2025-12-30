
import java.util.Scanner;

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter movie type (2D/3D): ");
            String movieType = sc.next();

            System.out.print("Enter seat type (gold/silver): ");
            String seatType = sc.next();

            System.out.print("Do you want snacks? (yes/no): ");
            String snacks = sc.next();

            int price = 0;

            switch (movieType) {
                case "2D":
                    price = 150;
                    break;
                case "3D":
                    price = 250;
                    break;
                default:
                    System.out.println("Invalid movie type");
            }

            if (seatType.equals("gold")) {
                price += 100;
            } else if (seatType.equals("silver")) {
                price += 50;
            }

            if (snacks.equals("yes")) {
                price += 80;
            }

            System.out.println("Total Ticket Price: ₹" + price);

            System.out.print("Next customer? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y');
    }
}
