package gcrcodebase.controlflow;

import java.util.*;
public class CheckDivisibilityBy5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//creating a variable number and storing the user input value in it
		System.out.println("Enter the number: ");
		double number = sc.nextDouble();
		
		
		//using the control flow to display the desired output.
		if(number%5==0) {
			System.out.printf("Is the number %s divisible by 5? %s", number, "Yes");
		}else {
			System.out.printf("Is the number %s divisible by 5? %s", number, "No");
		}
		
	}

}
