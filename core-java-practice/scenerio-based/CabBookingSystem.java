import java.util.*;

// Exception for no driver availability
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

// Fare calculator interface
interface FareCalculator {
    double calculateFare(double distance);
}

// Normal pricing logic
class NormalFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

// Peak hour pricing logic
class PeakFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

// User entity
class User {
    int id;
    String name;
    List<Ride> rideHistory = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addRide(Ride ride) {
        rideHistory.add(ride);
    }
}

// Driver entity
class Driver {
    int id;
    String name;
    boolean isavailable = true;

    public Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Ride entity
class Ride {
    static int counter = 1;

    int rideId;
    User user;
    Driver driver;
    String source;
    String destination;
    double distance;
    double fare;
    String status;

    public Ride(User user, String source, String destination, double distance) {
        this.rideId = counter++;
        this.user = user;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.status = "REQUESTED";
    }
}

// Service that manages ride operations
class RideService {
    List<Driver> drivers;//user input

    public RideService(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Ride bookRide(User user, String source, String destination, double distance) throws NoDriverAvailableException {

        Driver driver = assignDriver();
        Ride ride = new Ride(user, source, destination, distance);

        ride.driver = driver;
        ride.status = "ONGOING";
        driver.isavailable = false;

        FareCalculator fareCalculator = getFareCalculator();
        ride.fare = fareCalculator.calculateFare(distance);

        completeRide(ride);
        user.addRide(ride);

        return ride;
    }

    private Driver assignDriver() throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.isavailable) {
                return d;
            }
        }
        throw new NoDriverAvailableException("No drivers available");
    }

    //fare according to the hours
    private FareCalculator getFareCalculator() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 18 && hour <= 22) {
            return new PeakFareCalculator();
        }
        return new NormalFareCalculator();
    }

    private void completeRide(Ride ride) {
        ride.status = "COMPLETED";
        ride.driver.isavailable = true;
    }
}

// Main application
public class CabBookingSystem {
    public static void main(String[] args) {

        List<Driver> drivers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details of all drivers.");
        System.out.println("Enter the number of drivers.");
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            System.out.println("Enter driver id: ");
            int driverId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter the driver name: ");
            String driverName = sc.nextLine();
            drivers.add(new Driver(driverId, driverName));
        }
        RideService rideService = new RideService(drivers);

        System.out.println("Enter the user details: ");
        System.out.println("Enter the user Id: ");
        int userId=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the user name: ");
        String userName = sc.nextLine();
        User user = new User(userId, userName);

        try {
            System.out.println("Source: ");
            String source = sc.nextLine();

            System.out.println("Destination: ");
            String destination = sc.nextLine();

            System.out.println("Distance: ");
            double distance = sc.nextDouble();

            Ride ride = rideService.bookRide(user, source, destination, distance);
            System.out.println("Ride completed");
            System.out.println("Driver name " + ride.driver.name);
            System.out.println("Fare amount " + ride.fare);
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
