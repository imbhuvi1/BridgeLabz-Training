package gcr_codebase.streams;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
	int id;
	String name;
	String department;
	double salary;

	public Employee(int id, String name, String department, double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public void display() {
		System.out.println(id + " : " + name + " : " + department + " : " + salary);
	}
}

public class Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "employees.dat";
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Alice", "IT", 60000));
		empList.add(new Employee(102, "Bob", "HR", 45000));
		empList.add(new Employee(103, "Charlie", "Finance", 55000));
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(empList);
		} catch (IOException e) {
			System.out.println(e);
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			ArrayList<Employee> list = (ArrayList<Employee>) ois.readObject();
			System.out.println("Employee Details:");
			for (Employee emp : list) {
				emp.display();
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

}
