package gcr_codebase.this_static_final_keywords;

public class Student {
	
	//instance variables
	String name;
	final int rollNumber;
	String grade;
	static int totalStudents;
	
	//universityName is static variable shared across all students
	static String universityName = "GLA University Mathura";
	
	//method to display the number of students
	public static void displayTotalStudents() {
		System.out.println("Total Students Enrolled: "+totalStudents);
	}
	
	//constructor
	public Student(String name, int rollNumber, String grade) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
		totalStudents++;
	}
	
	public void displayDetails(Student obj) {
		if(obj instanceof Student) {
			System.out.println("University name: " + universityName);
			System.out.println("Roll Number: " + rollNumber);
			System.out.println("Name: " + name);
			System.out.println("Grade: " + grade);
			System.out.println();
		}else {
			System.out.println("Inavlid Instance.");
		}
	}
	
	public void updateGrade(String newGrade, Student obj) {
		this.grade = newGrade;
		System.out.println("Grade updated to: "+grade);
		displayDetails(obj);
	}
	
	//main method
	public static void main(String[] args) {
		Student obj = new Student("Bhuvnesh Singh Bhadauirya", 45, "B");
		Student obj1 = new Student("Arpit Gupta", 30, "A");
		
		displayTotalStudents();
		obj.displayDetails(obj);
		obj1.displayDetails(obj1);
		
		obj1.updateGrade("C", obj1);
	}
}
