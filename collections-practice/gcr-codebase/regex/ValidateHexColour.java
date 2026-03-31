package gcr_codebase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexColour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String regex = "^#[A-Za-z0-9]{6}$";
		Pattern pattern = Pattern.compile(regex);
		String colour = sc.nextLine();
		Matcher matcher = pattern.matcher(colour);
		if (matcher.matches()) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}

}
