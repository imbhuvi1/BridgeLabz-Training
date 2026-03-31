// Interface defining refueling behavior
interface Refuelable {
	void refuel();
}

// Superclass representing a general vehicle
class Vehicle{
	double maxSpeed; // in km/hr
	String model;
	
	// Constructor to initialize vehicle details
	public Vehicle(double maxSpeed, String model) {
		this.maxSpeed = maxSpeed;
		this.model = model;
	}
	
	// Displays basic vehicle information
	void displayDetails() {
		System.out.println("Maximum Speed: "+maxSpeed);
		System.out.println("Model: "+model);
	}
}

// Represents an electric vehicle, subclass of Vehicle
class ElectricVehicle extends Vehicle {

	// Constructor calling parent class constructor
	public ElectricVehicle(double maxSpeed, String model) {
		super(maxSpeed, model);
	}
	
	// Method specific to electric vehicles
	public void charge() {
		System.out.println("The Vehicle is charging.");
	}
}

// Represents a petrol vehicle, subclass of Vehicle and implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {

	// Constructor calling parent class constructor
	public PetrolVehicle(double maxSpeed, String model) {
		super(maxSpeed, model);
	}
	
	// Implementation of refuel method from Refuelable interface
	@Override
	public void refuel() {
		System.out.println("Vehicle is refueling");
	}
}

// Main class to execute and test the vehicle management system
public class VehicleManagementSystem {

	public static void main(String[] args) {

		// Creating and using ElectricVehicle object
		ElectricVehicle obj1 = new ElectricVehicle(250, "Tata");
		obj1.charge();
		obj1.displayDetails();
		
		System.out.println();
		
		// Creating and using PetrolVehicle object
		PetrolVehicle  obj2 = new PetrolVehicle (450, "Lamborgini");
		obj2.refuel();
		obj2.displayDetails();
	}

}
