package gcr_codebase.this_static_final_keywords;

public class Patient {
	
	//instance variables
	String name;
	int age;
	String ailment;
	final int patientID;
	
	//variable to count the number of total patients
	static int totalPatients;
	
	//name of a particular hospital
	static String hospitalName = "KD Dental Hospital";
	
	//method to display total number of patients in that hospital
	public static void getTotalPatients() {
		System.out.println("Total Patient Admitted: "+ totalPatients);
	}
	
	//constructor
	public Patient(String name, int age, String ailment,int patientID) {
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		this.patientID = patientID;
		totalPatients++;
	}
	
	//method to display the details
	public void displayDetails(Patient obj) {
		if(obj instanceof Patient) {
			System.out.println("Hospital name: "+hospitalName);
			System.out.println("Patient ID: "+patientID);
			System.out.println("Name: "+name);
			System.out.println("Age: "+age);
			System.out.println("Ailment: "+ailment);
			System.out.println();
		}else {
			System.out.println("Invalid Instance");
		}
	}
	
	//main method
	public static void main(String[] args) {
		Patient obj = new Patient("Shardul", 30, "Dental",01);
		Patient obj1 = new Patient("Nivrutti", 26, "OCD",02);
		
		getTotalPatients();
		
		obj.displayDetails(obj);
		obj1.displayDetails(obj1);
	}
}
