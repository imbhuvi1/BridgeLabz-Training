package gcr_codebase.programming_elements;

import java.util.*;
public class CalculateSimpleInterest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking principal, rate and time as input
		System.out.println("Enter prinicpal amount: ");
		double principal = sc.nextDouble();
		System.out.println("Enter rate: ");
		double rate = sc.nextDouble();
		System.out.println("Enter time: ");
		double time = sc.nextDouble();
		
		//calulating simple interest
		double simpleInterest = (principal * rate * time) / 100;
		
		//printing simple interest on screen
		System.out.println("Calculated Simple Interest is: " + simpleInterest);
	}

}
