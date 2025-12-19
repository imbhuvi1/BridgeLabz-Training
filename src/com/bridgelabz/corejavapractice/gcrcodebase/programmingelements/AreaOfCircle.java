package com.bridgelabz.corejavapractice.gcrcodebase.programmingelements;

import java.util.*;
public class AreaOfCircle {
	public static void main(String[] args) {
		final double pi = 3.14159265359;
		
		Scanner sc = new Scanner(System.in);
		
		//taking radius as input 
		System.out.println("Enter the radius of circle: ");
		double radiusOfCircle = sc.nextDouble();
		
		//calculating area using the formula
		double areaOfCircle = pi * Math.pow(radiusOfCircle, 2);
		
		//printing area of circle on screen 
		System.out.println(areaOfCircle);
	}

}
