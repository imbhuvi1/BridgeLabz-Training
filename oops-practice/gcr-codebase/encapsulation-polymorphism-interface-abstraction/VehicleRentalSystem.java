package gcr_codebase.encapsulation_polymorphism_interface_abstraction;

// Interface for insurance
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle {

    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Encapsulation
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rate per Day: " + rentalRate);
    }
}

// Car class
class Car extends Vehicle implements Insurable {

    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: ₹500";
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {

    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: ₹200";
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {

    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 1.2;
    }

    @Override
    public double calculateInsurance() {
        return 1000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: ₹1000";
    }
}

// Main class
public class VehicleRentalSystem {

    // Polymorphic method
    public static void calculateTotalCost(Vehicle vehicle, int days) {

        double rentalCost = vehicle.calculateRentalCost(days);
        double insurance = 0;

        if (vehicle instanceof Insurable) {
            insurance = ((Insurable) vehicle).calculateInsurance();
        }

        vehicle.displayDetails();
        System.out.println("Rental Cost: " + rentalCost);
        System.out.println("Insurance Cost: " + insurance);
        System.out.println("Total Cost: " + (rentalCost + insurance));
        System.out.println("");
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("CAR101", 1500);
        vehicles[1] = new Bike("BIKE202", 500);
        vehicles[2] = new Truck("TRK303", 3000);

        for (int i = 0; i < vehicles.length; i++) {
            calculateTotalCost(vehicles[i], 3);
        }
    }
}
