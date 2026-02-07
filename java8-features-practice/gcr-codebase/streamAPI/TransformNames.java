package gcr_codebase.streamapi;

import java.util.*;

public class TransformNames {
	public static void main(String[] args) {
		List<String> customerNames = List.of("Manish Pailwar", "Manish chahuhan","Bhuvnesh Singh Bhadauriya","Lovekush Rajput","Neetesh Singh Bhadauriya","Arpit Gupta");
		
		//using map method 
		System.out.println("Names of customers converted to uppercase and sorted alphabetically:\n");
		customerNames.stream()
			.map(c->c.toUpperCase()).
			sorted().
			forEach(System.out::println);
	}
}
