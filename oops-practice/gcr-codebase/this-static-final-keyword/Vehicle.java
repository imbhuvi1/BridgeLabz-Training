package gcr_codebase.this_static_final_keywords;

public class Vehicle {
	
	//instance variables
	String ownerName;
	String vehicleType;
	final String registrationNumber;
	
	//static variable registrationFee that uniquely identify each vehicle
	static double registrationFee = 150;
	
	//method to update the registration fee
	public static void updateRegistrationFee(double newRegistraionFee) {
		registrationFee = newRegistraionFee;
		System.out.println("The new registration fee: "+registrationFee);
	}
	
	//constructor
	public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
		this.registrationNumber = registrationNumber;
	}
	
	//method to display the details
	public void displayDetail(Vehicle obj) {
		if(obj instanceof Vehicle) {
			System.out.println("Owner Name: "+ownerName);
			System.out.println("Vehicle Name: "+vehicleType);
			System.out.println("Resgistration Number: "+registrationNumber);
			System.out.println("Registration Fee: "+registrationFee);
			System.out.println();
		}else {
			System.out.println("Invalid instance.");
		}
	}
	
	//main method
	public static void main(String[] args) {
		Vehicle obj = new Vehicle("Arpit Gupta", "Lamborigini", "UP83 SM0001");
		Vehicle obj1 = new Vehicle("Bhuvnesh Singh Bhadauriya", "Thar Mahindra", "UP25 SA7451");
		
		obj.displayDetail(obj);
		obj1.displayDetail(obj1);
		
	}
}
