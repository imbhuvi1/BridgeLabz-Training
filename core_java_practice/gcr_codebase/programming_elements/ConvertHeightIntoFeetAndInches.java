package gcr_codebase.programming_elements;

import java.util.*;
public class ConvertHeightIntoFeetAndInches {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Creating heightInCentimeteres variable to take input from user of height in cm and store in it.
		System.out.println("Enter the height (in centimeteres): ");
		double heightInCentimeteres = sc.nextInt();
		
		
		//Computing the height in inches and assigning to heightInInches variable
		double heightInInches = heightInCentimeteres/2.54;
		
		//Computing the height in foot and assigning to heightInFoot variable
		double heightInFeet = heightInInches/12;
		
		//Displaying height in inches, foot and centimeters
		System.out.printf("Your Height in cm is %s while in feet is %s and inches is %s", heightInCentimeteres, heightInFeet, heightInInches);
		
		

		
	}

}
