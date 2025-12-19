package com.corejavapractice.gcrcodebase.programmingelements;

import java.util.*;
public class PowerCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking two numbers as input a base and an exponent
		System.out.println("Enter base: ");
		double base = sc.nextDouble();
		
		System.out.println("Enter exponent: ");
		double exponent = sc.nextDouble();
		
		//calculating power
		double calculatedPower = Math.pow(base, exponent);
		
		//printing calculated power on screen
		System.out.println("The calculated power is: "+ calculatedPower);
	}

}
