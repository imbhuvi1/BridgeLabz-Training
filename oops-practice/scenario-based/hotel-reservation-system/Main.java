package scenario_based.HotelReservationSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // room setup
        Room room;
        System.out.print("Choose Room Type (1-Standard, 2-Deluxe): ");
        int roomChoice = sc.nextInt();

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        if (roomChoice == 2) {
            room = new DeluxeRoom(roomNo);
        } else {
            room = new StandardRoom(roomNo);
        }

        // guest input
        System.out.print("Enter Guest ID: ");
        int gid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Guest Name: ");
        String gname = sc.nextLine();

        Guest guest = new Guest(gid, gname);

        System.out.print("Enter Number of Days: ");
        int days = sc.nextInt();

        System.out.print("Is it peak season? (yes/no): ");
        sc.nextLine();
        String season = sc.nextLine();

        PricingStrategy pricing;
        if (season.equalsIgnoreCase("yes")) {
            pricing = new SeasonalPricing();
        } else {
            pricing = new NormalPricing();
        }

        try {
            if (!room.isAvailable()) {
                throw new RoomNotAvailableException("Room is not available");
            }

            room.checkIn();
            Reservation reservation = new Reservation(guest, room, days);

            double bill = pricing.calculatePrice(room.getBasePrice(), days);
            reservation.setTotalAmount(bill);

            System.out.println("\n--- Invoice ---");
            reservation.displayInvoice();

            // checkout
            room.checkOut();
            System.out.println("Checked out successfully");

        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
