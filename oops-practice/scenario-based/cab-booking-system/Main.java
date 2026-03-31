package scenario_based.CabBookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // sample drivers
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver(1, "Amit"));
        drivers.add(new Driver(2, "Rohit"));

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter User Name: ");
        String userName = sc.nextLine();

        User user = new User(userId, userName);

        System.out.print("Enter Distance (km): ");
        double distance = sc.nextDouble();

        System.out.println("Choose Pricing:");
        System.out.println("1. Normal");
        System.out.println("2. Peak");

        int choice = sc.nextInt();

        FareCalculator fareCalculator;
        if (choice == 2) {
            fareCalculator = new PeakFareCalculator();
        } else {
            fareCalculator = new NormalFareCalculator();
        }

        try {
            Driver assignedDriver = assignDriver(drivers);
            Ride ride = new Ride(user, assignedDriver, distance);

            double fare = fareCalculator.calculateFare(distance);
            ride.setFare(fare);

            assignedDriver.setAvailable(false);

            System.out.println("\nRide Details:");
            ride.displayRide();

        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

    // driver assignment logic
    public static Driver assignDriver(List<Driver> drivers) throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                return d;
            }
        }
        throw new NoDriverAvailableException("No Driver Available at the moment");
    }
}
