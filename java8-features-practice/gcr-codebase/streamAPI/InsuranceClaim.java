package gcr_codebase.streamapi;

import java.util.*;
import java.util.stream.Collectors;

//Claim class
class Claims {
	protected String claimName;
	protected double claimAmount;

	public Claims(String claimName, double claimAmount) {
		this.claimAmount = claimAmount;
		this.claimName = claimName;
	}

//	public double averageClaim() {
//		
//	}

}

//Main class
public class InsuranceClaim {
	public static void main(String[] args) {
		List<Claims> claims = List.of(new Claims("Health Claim", 45000), new Claims("Motor Claim", 550.5),
				new Claims("Life Cliam", 100000), new Claims("Health Claim", 55000), new Claims("Motor Claim", 430.4),
				new Claims("Life Cliam", 150600), new Claims("Health Claim", 90000), new Claims("Motor Claim", 900),
				new Claims("Life Cliam", 800000));

		// Finding the average claim amount for each claim type.
		System.out.println("Average claim amount for each claim type-\n");
		claims.stream()
			.collect(
				Collectors.groupingBy(
						c -> c.claimName,
						Collectors.averagingDouble(c->c.claimAmount)
				)
			)
			.forEach((type,avg) -> System.out.println(type+" : "+String.format("%4f",avg)));
				

	}
}
