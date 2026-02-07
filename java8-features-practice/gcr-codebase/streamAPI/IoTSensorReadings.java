package gcr_codebase.streamapi;

import java.util.*;

public class IoTSensorReadings {
	public static void main(String[] args) {

		List<Double> readings = Arrays.asList(28.5, 35.2, 22.0, 40.1);
		double threshold = 30.0;

		// Print readings above threshold
		readings.stream().filter(r -> r > threshold).forEach(r -> System.out.println("High Reading: " + r));
	}
}
