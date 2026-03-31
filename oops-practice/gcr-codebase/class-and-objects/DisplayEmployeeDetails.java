import java.util.*;

class Employee {
	String name;
	private int id;
	private double salary;

	Employee() {
		this.name = "Name";
		this.id = 0;
		this.salary = 0;
	}

	Employee(String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public void displayDetails() {
		System.out.println("Name " + name);
		System.out.println("ID " + id);
		System.out.println("Salary " + salary);
		System.out.println();
	}
}

public class DisplayEmployeeDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee("Rohan", 1, 500000);
		Employee emp2 = new Employee();
		emp2.name = "Govind";
		emp2.setId(2);
		emp2.setSalary(100000);
		emp1.displayDetails();
		emp2.displayDetails();
	}

}