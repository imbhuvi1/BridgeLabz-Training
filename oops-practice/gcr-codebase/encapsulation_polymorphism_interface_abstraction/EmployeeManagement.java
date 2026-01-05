package gcr_codebase.encapsulation_polymorphism_interface_abstraction;

interface Department{
	void assignDepartment(String deptName);
	String getDepartmentDetails();
}

abstract class Employee implements Department{
	private int employeeId;
	private String name;
	protected double baseSalary;
	
	private String department;
	
	public Employee(int employeeId,String name, double baseSalary) {
		this.employeeId = employeeId;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	
	public abstract double calculateSalary();
	
	public void displayDetails() {
		System.out.println("Employee Id: "+employeeId);
		System.out.println("Name: "+name);
		if (baseSalary > 0) {
		    System.out.println("Base Salary: " + baseSalary);
		} else {
			System.out.println("Base Salary: Not Applicable");
		}
		System.out.println("Department: " + department);
		System.out.println("Final Salary: " + calculateSalary());
	}
	
	@Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

class FullTimeEmployee extends Employee{
	private static double fixedSalary = 50000;
	
	public FullTimeEmployee(int employeeId,String name) {
		super(employeeId, name, fixedSalary);
	}
	
	@Override
	public double calculateSalary() {
		return fixedSalary;
	}
}

class PartTimeEmployee extends Employee{
	private int workHours;
	private double hourlyRate;
	
	public PartTimeEmployee(int employeeId, String name, double baseSalary,int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }
	
	@Override
	public double calculateSalary() {
		return workHours*hourlyRate;
	}
}


public class EmployeeManagement {

	public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(101, "Rahul");
        Employee e2 = new PartTimeEmployee(102, "Anita", 25000,20, 500);

        e1.assignDepartment("IT");
        e1.displayDetails();
        
        System.out.println();
        e2.assignDepartment("HR");
        e2.displayDetails();

	}

}
