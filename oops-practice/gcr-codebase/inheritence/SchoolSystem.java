//Represents a generic person in the school system
class Person{
	String name;
	int age;
	
	//Constructor to initialize name and age
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//Displays basic details of a person
	void displayDetails() {
		System.out.println("\nName: "+name);
		System.out.println("Age: "+age);
	}
}

//Represents a teacher, which is a type of person
class Teacher extends Person {
	String subject;

	//Constructor initializes parent and teacher data
	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}
	
	//Displays teacher role information
	void displayRole() {
		displayDetails(); // Inherited method
		System.out.println("Role: Teacher");
		System.out.println("Subject: "+subject);
	}

}


//Represents a student, which is a type of person
class Student extends Person {
	char grade;

	//Constructor initializes parent and student data
	public Student(String name, int age, char grade) {
		super(name, age);
		this.grade = grade;
	}
	
	//Displays student role information
	void displayRole() {
		displayDetails(); // Inherited method
		System.out.println("Role: Student");
		System.out.println("Grade: "+grade);
	}
}

//Represents a staff member, which is a type of person
class Staff extends Person {
	String dateOfJoining;

	//Constructor initializes parent and staff data
	public Staff(String name, int age, String dateOfJoining) {
		super(name, age);
		this.dateOfJoining = dateOfJoining;
	}
	
	//Displays staff role information
	void displayRole() {
		displayDetails(); // Inherited method
		System.out.println("Role: Staff");
		System.out.println("Date of Joining: "+dateOfJoining);
	}
}

public class SchoolSystem {
	public static void main(String[] args) {

		//Creating Teacher object
		Teacher object1 = new Teacher("Shardul", 35, "BridgeLabz-Training");
		object1.displayRole();
		
		//Creating Student object
		Student object2 = new Student("Bhuvnesh Singh Bhadauriya", 21, 'A');
		object2.displayRole();
		
		//Creating Staff object
		Staff object3 = new Staff("Ankhi Saha", 28, "01-01-2026");
		object3.displayRole();
	}
}
