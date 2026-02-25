package gcr_codebase.lambda_expression;

import java.util.*;

public class UppercaseEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> empName = List.of("Govind", "Akash", "Aman");
		List<String> upperCase = empName.stream().map(String::toUpperCase).toList();
		System.out.println(upperCase);
	}

}
