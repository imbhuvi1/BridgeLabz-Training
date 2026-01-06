package gcr_codebase.encapsulation_polymorphism_interface_abstraction;

//Interface for GPS related operations
interface GPS {
  String getCurrentLocation();
  void updateLocation(String location);
}

//Abstract class representing a vehicle
abstract class Vehicles {
  private int vehicleId;
  private String driverName;
  private double ratePerKm;

  public Vehicles(int vehicleId, String driverName, double ratePerKm) {
      this.vehicleId = vehicleId;
      this.driverName = driverName;
      this.ratePerKm = ratePerKm;
  }

  //Abstract method for fare calculation
  public abstract double calculateFare(double distance);

  //Concrete method to display vehicle details
  public void getVehicleDetails() {
      System.out.println("Vehicle ID: " + vehicleId);
      System.out.println("Driver Name: " + driverName);
      System.out.println("Rate Per Km: " + ratePerKm);
  }

  protected double getRatePerKm() {
      return ratePerKm;
  }
}

//Class representing car
class Cars extends Vehicles implements GPS {

  private String location = "Unknown";

  public Cars(int vehicleId, String driverName, double ratePerKm) {
      super(vehicleId, driverName, ratePerKm);
  }

  //Override fare calculation
  @Override
  public double calculateFare(double distance) {
      return getRatePerKm() * distance + 50;
  }

  //Return current location
  @Override
  public String getCurrentLocation() {
      return location;
  }

  //Update location
  @Override
  public void updateLocation(String location) {
      this.location = location;
  }
}

//Class representing bike
class Bikes extends Vehicles implements GPS {

  private String location = "Unknown";

  public Bikes(int vehicleId, String driverName, double ratePerKm) {
      super(vehicleId, driverName, ratePerKm);
  }

  //Override fare calculation
  @Override
  public double calculateFare(double distance) {
      return getRatePerKm() * distance;
  }

  //Return current location
  @Override
  public String getCurrentLocation() {
      return location;
  }

  //Update location
  @Override
  public void updateLocation(String location) {
      this.location = location;
  }
}

//Class representing auto
class Auto extends Vehicles implements GPS {

  private String location = "Unknown";

  public Auto(int vehicleId, String driverName, double ratePerKm) {
      super(vehicleId, driverName, ratePerKm);
  }

  //Override fare calculation
  @Override
  public double calculateFare(double distance) {
      return (getRatePerKm() * distance) + 20;
  }

  //Return current location
  @Override
  public String getCurrentLocation() {
      return location;
  }

  //Update location
  @Override
  public void updateLocation(String location) {
      this.location = location;
  }
}

//Main class demonstrating polymorphism
public class RideHailingApplication {

  public static void calculateRideFare(Vehicles vehicle, double distance) {

      vehicle.getVehicleDetails();
      System.out.println("Distance: " + distance);
      System.out.println("Total Fare: " + vehicle.calculateFare(distance));
      System.out.println();
  }

  public static void main(String[] args) {

      Vehicles car = new Cars(1, "Amit", 15);
      Vehicles bike = new Bikes(2, "Ravi", 8);
      Vehicles auto = new Auto(3, "Suresh", 10);

      calculateRideFare(car, 10);
      calculateRideFare(bike, 10);
      calculateRideFare(auto, 10);
  }
}
