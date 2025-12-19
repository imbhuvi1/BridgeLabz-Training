package com.bridgelabz.corejavapractice.gcrcodebase.programmingelements;

import java.util.*;
public class AverageOfThreeNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking three numbers as input
		System.out.println("Enter firstNumber: ");
		double firstNumber = sc.nextDouble();
		
		System.out.println("Enter secondNumber: ");
		double secondNumber = sc.nextDouble();
		
		System.out.println("Enter thirdNumber: ");
		double thirdNumber = sc.nextDouble();
		
		//calculating average of three numbers
		double averageOfThreeNumbers = (firstNumber+secondNumber+thirdNumber)/3;
		
		//printing calculated average of three numbers on screen
		System.out.println("Calculated average of three numbers is: "+ averageOfThreeNumbers);
	}
}
