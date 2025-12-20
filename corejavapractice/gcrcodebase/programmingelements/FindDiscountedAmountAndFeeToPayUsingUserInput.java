package com.corejavapractice.gcrcodebase.programmingelements;

import java.util.*;
public class FindDiscountedAmountAndFeeToPayUsingUserInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Creating a variable and taking user input and storing the value in it.
		System.out.println("Enter the fee of the student of the course: ");
		int fee = sc.nextInt();
		
		//Creating a variable discountPercent and taking user input and storing the value in it.
		System.out.println("Enter the discount the University is willing to offer: ");
		int discountPercent = sc.nextInt();
		
		//Computing discount and assign it to the discount variable.
		int discountedAmount = (fee*10)/100;
		
		//Computing the discounted amount and assigning to discountedAmount variable
		int discountedFee = fee - discountedAmount;
		
		//Displaying the fee student has to pay
		System.out.printf("The discount amount is INR %s and final discounted fee is INR %s",discountedAmount,discountedFee);
		
		
	}
}
