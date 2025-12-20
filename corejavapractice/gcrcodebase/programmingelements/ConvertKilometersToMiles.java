package com.corejavapractice.gcrcodebase.programmingelements;

import java.util.*;
public class ConvertKilometersToMiles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking distance as input (in km)
		System.out.println("Enter distance(in km): ");
		double distanceInKm = sc.nextDouble();
		
		//converting distance in miles
		double distanceInMiles = distanceInKm * 0.621371;
		
		//printing distance in miles
		System.out.printf("The total miles is %s mile for the given %s km",distanceInMiles,distanceInKm);
	}

}
