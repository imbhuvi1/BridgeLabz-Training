// Interface defining common work behavior
interface Worker{
	void performDuties();
}

// Base class representing a person in the restaurant
class PersonCopy{
	String name;
	int id;
	
	// Constructor to initialize name and id
	public PersonCopy(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	// Displays basic person details
	void displayDetails() {
		System.out.println("Name: "+name);
		System.out.println("Id: "+id);
	}
}

// Represents a Chef who is a Person and a Worker
class Chef extends PersonCopy implements Worker{

	// Constructor calling parent class constructor
	public Chef(String name, int id) {
		super(name, id);
	}
	
	// Implements work responsibility of a Chef
	@Override
	public void performDuties() {
		System.out.println(name+" is on duty as chef");
	}
}

// Represents a Waiter who is a Person and a Worker
class Waiter extends PersonCopy implements Worker{

	// Constructor calling parent class constructor
	public Waiter(String name, int id) {
		super(name, id);
	}
	
	// Implements work responsibility of a Waiter
	@Override
	public void performDuties() {
		System.out.println(name+" is on duty as waiter");
	}
}

// Main class to run the restaurant management system
public class RestaurantManagementSystem {

	public static void main(String[] args) {

		// Creating Chef object
		Chef obj1 = new Chef("Raj gupta", 102);
		obj1.performDuties();
		obj1.displayDetails();
		
		System.out.println();
		
		// Creating Waiter object
		Waiter obj2 = new Waiter("Anu", 134);
		obj2.performDuties();
		obj2.displayDetails();
	}

}
