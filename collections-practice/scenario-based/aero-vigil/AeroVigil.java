package scenario_based;

import java.util.*;
class FlightUtil {
	public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
		String flightRegex = "^FL-[1-9][0-9]{3}$";
		if (flightNumber == null || !flightNumber.matches(flightRegex)) {
			throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
		}
		return true;
	}

	public boolean validateFlightName(String flightName) throws InvalidFlightException {
		if (!flightName.equalsIgnoreCase("SpiceJet") && !flightName.equalsIgnoreCase("Vistara")
				&& !flightName.equalsIgnoreCase("IndiGo") && !flightName.equalsIgnoreCase("Air Arabia")) {
			throw new InvalidFlightException("The flight name " + flightName + " is invalid");
		}
		return true;
	}

	public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
		int maxCapacity;
		switch (flightName) {
		case "SpiceJet" -> {
			maxCapacity = 396;
		}
		case "Vistara" -> {
			maxCapacity = 615;
		}
		case "IndiGo" -> {
			maxCapacity = 230;
		}
		case "Air Arabia" -> {
			maxCapacity = 130;
		}
		default -> {
			throw new InvalidFlightException("The flight name " + flightName + " is invalid");
		}
		}
		if (passengerCount <= 0 || passengerCount > maxCapacity) {
			throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
		}
		return true;
	}

	public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
		int maxCapacity;
		switch (flightName) {
		case "SpiceJet" -> {
			maxCapacity = 200000;
		}
		case "Vistara" -> {
			maxCapacity = 300000;
		}
		case "Indigo" -> {
			maxCapacity = 250000;
		}
		case "Air Arabia" -> {
			maxCapacity = 150000;
		}
		default -> {
			throw new InvalidFlightException("The flight name " + flightName + " is invalid");
		}
		}
		if (currentFuelLevel <= 0 || currentFuelLevel > maxCapacity) {
			throw new InvalidFlightException("Invalid fuel level for " + flightName);
		}
		return maxCapacity - currentFuelLevel;
	}
}

class InvalidFlightException extends Exception {
	public InvalidFlightException(String message) {
		super(message);
	}
}

public class AeroVigil {

	public static void main(String[] args) {

		FlightUtil flightUtil = new FlightUtil();

		System.out.println("Enter flight details");

		try (Scanner sc = new Scanner(System.in);) {
			String input = sc.nextLine();
			String[] data = input.split(":");

			String flightNumber = data[0];
			String flightName = data[1];
			int passengerCount = Integer.parseInt(data[2]);
			double currentFuelLevel = Double.parseDouble(data[3]);

			flightUtil.validateFlightNumber(flightNumber);
			flightUtil.validateFlightName(flightName);
			flightUtil.validatePassengerCount(passengerCount, flightName);

			double fuelRequired = flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);

			System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

		} catch (InvalidFlightException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
