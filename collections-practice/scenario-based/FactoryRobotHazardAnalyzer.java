package scenario_based;

import java.util.*;

public class FactoryRobotHazardAnalyzer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Arm Precision (0.0 - 1.0):");
			double armPrecision = Double.parseDouble(sc.nextLine());
			System.out.println("Enter Worker Density (1 - 20):");
			int workerDensity = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
			String machineryState = sc.nextLine();
			RobotHazardAuditor auditor = new RobotHazardAuditor();
			double risk = auditor.calculateHazardRisk(armPrecision, workerDensity, machineryState);
			System.out.println("Robot Hazard Risk Score: " + risk);
		} catch (RobotSafetyException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error: Invalid input format.");
		}
	}
}

class RobotHazardAuditor {
	public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState)
			throws RobotSafetyException {
		if (armPrecision < 0.0 || armPrecision > 1.0) {
			throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
		}
		if (workerDensity < 1 || workerDensity > 20) {
			throw new RobotSafetyException("Error: Worker density must be 1-20");
		}
		machineryState = machineryState.toLowerCase();
		double machineRiskFactor;
		switch (machineryState) {
		case "worn" -> {
			machineRiskFactor = 1.3;
		}
		case "faulty" -> {
			machineRiskFactor = 2.0;
		}
		case "critical" -> {
			machineRiskFactor = 3.0;
		}
		default -> {
			throw new RobotSafetyException("Error: Unsupported machinery state");
		}
		}
		double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
		return hazardRisk;
	}
}

class RobotSafetyException extends Exception {
	public RobotSafetyException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
