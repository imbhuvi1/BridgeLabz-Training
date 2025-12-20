package com.corejavapractice.gcrcodebase.controlflow;

import java.util.*;
public class CheckFirstSmallest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking three numbers input from user
		//and storing them in variables.
		System.out.println("Enter the first number: ");
		double number1 = sc.nextDouble();
		
		System.out.println("Enter the second number: ");
		double number2 = sc.nextDouble();
		
		System.out.println("Enter the third number: ");
		double number3 = sc.nextDouble();
		
		// Logic to check the first is smallest
        boolean isFirstSmallest  = false;
        if(number1<number2) {
        	if(number1<number3) {
        		isFirstSmallest = true;
        	}
        }
        
        // Displaying the output on screen
        System.out.println("Is the first number the smallest?  " + isFirstSmallest);	
	}

}
