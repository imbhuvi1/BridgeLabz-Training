package gcr_codebase.this_static_final_keywords;

public class Employee {
	
	//instance variables
	String name;
	final int id;
	String designation;
	static int totalEmployees = 0;
	
	//constructor
	public Employee(String name, int id, String designation) {
		this.name = name;
		this.id = id;
		this.designation = designation;
		totalEmployees++;
	}
	
	public void displayDetails(Employee obj) {
		if(obj instanceof Employee) {
			System.out.println("Company Name: "+companyName);
			System.out.println("Employee ID: "+id);
			System.out.println("Name: "+name);
			System.out.println("Designmation: "+designation);
			System.out.println();
		}else {
			System.out.println("Invalid Instance");
		}
	}
	
	//name of company shared by all employees
	static String companyName = "BridgeLabz";
	
	//method to display number of employees
	static void displayTotalEmployees() {
		System.out.println("Total Employees: "+ totalEmployees);
	}
	
	//main method
	public static void main(String[] args) {
		Employee obj = new Employee("Bhuvnesh Singh Bhadauriya", 45, "Capgemini Intern-4.25LPA");
		Employee obj1 = new Employee("Arpit Gupta", 30, "Capgemini Intern-7.5LPA");
		
		obj.displayTotalEmployees();
		
		obj.displayDetails(obj);
		obj1.displayDetails(obj1);
	}

}
