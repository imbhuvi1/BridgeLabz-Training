class Student {
	String name;
	String rollNumber;
	int marks1;
	int marks2;
	int marks3;

	Student(String name, String rollNumber, int marks1, int marks2, int marks3) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}

	public String calculateGrade() {
		double average = (marks1 + marks2 + marks3) / 3.0;
		if (average >= 90) {
			return "O";
		}
		if (average >= 80) {
			return "A";
		}
		if (average >= 70) {
			return "B";
		}
		if (average >= 60) {
			return "C";
		}
		if (average >= 50) {
			return "D";
		}
		return "F";
	}

	public void displayResult() {
		System.out.println("Student Name: " + name);
		System.out.println("Student RollNumber: " + rollNumber);
		System.out.println("Student Marks:");
		System.out.println("Marks1: " + marks1);
		System.out.println("Marks2: " + marks2);
		System.out.println("Marks3: " + marks3);
		System.out.println("Grade " + calculateGrade());
	}
}

public class SimulateStudentReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("Thamarai", "ECE001", 80, 70, 75);
		Student s2 = new Student("Kannan", "CSC002", 65, 60, 50);
		s1.displayResult();
		s2.displayResult();
	}

}