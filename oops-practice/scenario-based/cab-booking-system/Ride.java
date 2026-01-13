package scenario_based.CabBookingSystem;

// Ride entity
public class Ride {

    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, double distance) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void displayRide() {
        System.out.println("User: " + user.getName());
        System.out.println("Driver: " + driver.getName());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: ₹" + fare);
    }
}
