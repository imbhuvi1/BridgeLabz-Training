package gcr_codebase.methods;

import java.util.*;
public class NumberOfRounds {

	//Method to calculate rounds
	public static double calculateRounds(int distance, double perimeter) {
		return (distance/perimeter);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking input of three sides
		System.out.println("Enter the sides of the triangle: ");
		System.out.println("Enter first side: ");
		double side1 = sc.nextDouble();
		
		System.out.println("Enter second side: ");
		double side2 = sc.nextDouble();
		
		System.out.println("Enter third side: ");
		double side3 = sc.nextDouble();
		
		//calculating peri-meter
		double perimeter = side1 + side2 + side3;
		
		//user needs to complete in 5km
		int distance = 5; 
		
		//calling method to find the number of rounds
		System.out.println("The number of rounds user needs to complete is: "+calculateRounds(distance, perimeter));
		
		sc.close();
	}

}
