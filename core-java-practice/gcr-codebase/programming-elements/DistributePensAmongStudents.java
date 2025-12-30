package gcr_codebase.programming_elements;

public class DistributePensAmongStudents {

	public static void main(String[] args) {
		// creating variables to store total number of pens and total number of students
		int totalPens = 14;
		int totalStudents = 3;

		// creating variables to calculate pens per student and remaining pens
		int pensPerStudent = totalPens / totalStudents;
		int remainingPens = totalPens % totalStudents;

		// Displaying the number of pens per student and remaining pens
		System.out.println("The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is " + remainingPens);
	}

}
