package gcr_codebase.functional_interface;

import java.util.List;
import java.util.function.Predicate;

public class TemperatureAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<Double> checkTemperature = temp -> temp > 40 || temp < 5;
		List<Double> temperature = List.of(3.4, 4.2, 5.1, 6.3, 7.4, 44.5, 48.4, 40.1);
		for (double temp : temperature) {
			if (checkTemperature.test(temp)) {
				System.out.println("Alert! Extreme temperature: " + temp);
			}
		}
	}

}
