package scenario_based;

import java.util.*;

class Vessel {

	private String vesselId;
	private String vesselName;
	private double averageSpeed;
	private String vesselType;

	// No-argument constructor
	public Vessel() {
	}

	// Four-argument constructor
	public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
		this.vesselId = vesselId;
		this.vesselName = vesselName;
		this.averageSpeed = averageSpeed;
		this.vesselType = vesselType;
	}

	// Getters and Setters
	public String getVesselId() {
		return vesselId;
	}

	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public String getVesselType() {
		return vesselType;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}
}

class VesselUtil {

	private List<Vessel> vesselList = new ArrayList<>();

	public List<Vessel> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}

	// Requirement 1
	public void addVesselPerformance(Vessel vessel) {
		vesselList.add(vessel);
	}

	// Requirement 2
	public Vessel getVesselById(String vesselId) {
		for (Vessel vessel : vesselList) {
			if (vessel.getVesselId().equals(vesselId)) {
				return vessel;
			}
		}
		return null;
	}

	// Requirement 3
	public List<Vessel> getHighPerformanceVessels() {
		List<Vessel> result = new ArrayList<>();

		if (vesselList.isEmpty()) {
			return result;
		}

		double maxSpeed = 0;
		for (Vessel vessel : vesselList) {
			if (vessel.getAverageSpeed() > maxSpeed) {
				maxSpeed = vessel.getAverageSpeed();
			}
		}

		for (Vessel vessel : vesselList) {
			if (vessel.getAverageSpeed() == maxSpeed) {
				result.add(vessel);
			}
		}

		return result;
	}
}

//Main class : OceanFleet
public class OceanFleet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		VesselUtil vesselUtil = new VesselUtil();

		System.out.println("Enter the number of vessels to be added");
		int n = sc.nextInt();
		sc.nextLine(); // consume newline

		System.out.println("Enter vessel details");
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			String[] data = input.split(":");

			Vessel vessel = new Vessel(data[0], data[1], Double.parseDouble(data[2]), data[3]);

			vesselUtil.addVesselPerformance(vessel);
		}

		System.out.println("Enter the Vessel Id to check speed");
		String searchId = sc.nextLine();

		Vessel found = vesselUtil.getVesselById(searchId);

		if (found != null) {
			System.out.println(found.getVesselId() + " | " + found.getVesselName() + " | " + found.getVesselType()
					+ " | " + found.getAverageSpeed() + " knots");
		} else {
			System.out.println("Vessel Id " + searchId + " not found");
		}

		System.out.println("High performance vessels are");
		List<Vessel> highPerf = vesselUtil.getHighPerformanceVessels();
		for (Vessel v : highPerf) {
			System.out.println(v.getVesselId() + " | " + v.getVesselName() + " | " + v.getVesselType() + " | "
					+ v.getAverageSpeed() + " knots");
		}

		sc.close();
	}
}
