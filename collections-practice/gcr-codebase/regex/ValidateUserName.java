package gcr_codebase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUserName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
		Pattern pattern = Pattern.compile(regex);
		String userName = sc.nextLine();
		Matcher matcher = pattern.matcher(userName);
		if (matcher.matches()) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}

}
