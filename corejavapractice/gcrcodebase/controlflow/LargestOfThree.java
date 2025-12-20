package com.corejavapractice.gcrcodebase.controlflow;

import java.util.*;
public class LargestOfThree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking three numbers as input
		System.out.println("Enter the first number: ");
		int number1 = sc.nextInt();
		
		System.out.println("Enter the second number: ");
		int number2 = sc.nextInt();
		
		System.out.println("Enter the third number: ");
		int number3 = sc.nextInt();
		
		//logic to check which is largest
		boolean isFirstLargest = false;
		boolean isSecondLargest = false;
		boolean isThirdLargest = false;
		
		if(number1>number2 && number1>number3) {
			isFirstLargest = true;
		}else if(number2>number1 && number2>number3) {
			isSecondLargest = true;
		}else {
			isThirdLargest = true;
		}
		
		//Displaying that is the number largest or not
		System.out.printf("Is the first number the largest? %s \r\n"
				+ "Is the second number the largest? %s \r\n"
				+ "Is the third number the largest? %s \r\n", isFirstLargest, isSecondLargest, isThirdLargest);
	}

}
