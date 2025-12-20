package com.corejavapractice.gcrcodebase.programmingelements;

public class ConvertKilometersToMilesAnotherQues {

	public static void main(String[] args) {
		// creating variables to store distance in kilometers and conversion factor
		double distanceInKilometers = 10.8;
		double conversionFactor = 1.6;

		// creating a variable to calculate distance in miles
		double distanceInMiles = distanceInKilometers * conversionFactor;

		// Displaying the converted distance in miles
		System.out.println("The distance " + distanceInKilometers + " km in miles is " + distanceInMiles);
	}

}
