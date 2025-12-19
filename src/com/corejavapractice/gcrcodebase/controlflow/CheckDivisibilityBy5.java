package com.corejavapractice.gcrcodebase.controlflow;

import java.util.*;
public class CheckDivisibilityBy5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//creating a variable number and storing the user input value in it
		System.out.println("Enter the number: ");
		double number = sc.nextDouble();
		
		
		//using the control flow to display the desired output.
		if(number%5==0) {
<<<<<<< HEAD
			System.out.printf("Is the number %s divisible by 5? %s", number, "Yes");
		}else {
			System.out.printf("Is the number %s divisible by 5? %s", number, "No");
=======
			System.out.printf("Is the number %s divisible by 5? : %s", number, "Yes");
		}else {
			System.out.printf("Is the number %s divisible by 5? : %s", number, "No");
>>>>>>> ee068c8d47cc9b6cb6540865b30cc708fcb4ee03
		}
		
	}

}
