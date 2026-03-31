package gcr_codebase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicensePlate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String regex = "^[A-Z]{2}\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		String licensePlate = sc.nextLine();
		Matcher matcher = pattern.matcher(licensePlate);
		if (matcher.matches()) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}

}
