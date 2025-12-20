package gcrcodebase.programmingelements;

public class FindAverageMarksOfSam {

	public static void main(String[] args) {
		// creating a variable mathsMarks to indicate marks obtained in Maths
		int mathsMarks = 94;

		// creating a variable physicsMarks to indicate marks obtained in Physics
		int physicsMarks = 95;

		// creating a variable chemistryMarks to indicate marks obtained in Chemistry
		int chemistryMarks = 96;

		// creating a variable totalMarks to calculate total marks in PCM
		int totalMarks = mathsMarks + physicsMarks + chemistryMarks;

		// creating a variable numberOfSubjects to indicate total number of subjects
		int numberOfSubjects = 3;

		// creating a variable averageMarks to calculate average marks in PCM
		double averageMarks = (double) totalMarks / numberOfSubjects;

		// Displaying the calculated average marks of Sam
		System.out.println("Average marks of Sam in PCM is: " + averageMarks);
	}

}
