package gcrcodebase.programmingelements;

import java.util.*;
public class CelsiusToFahernheit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking a input in Celsius
		System.out.println("Enter the temperature in Celsius: ");
		int temperatureInCelsius = sc.nextInt();
		
		//converting tempreature from Celsius to Fahrenheit
		int temperatureInFahrenheit = ((temperatureInCelsius *9)/5) + 32;
		
		//printing the converted temperature 
		System.out.println("Converted temperature in fahrenheit is: " + temperatureInFahrenheit);
		

	}

}
