package gcr_codebase.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateCreditCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String visaRegex = "^4\\d{15}$";
		String masterRegex = "^5\\d{15}$";
		String card = sc.nextLine().trim();
		if(Pattern.matches(visaRegex, card)) {
			System.out.println("Visa");
		}
		else if(Pattern.matches(masterRegex, card)) {
			System.out.println("MasterCard");
		}
		else {
			System.out.println("Invalid");
		}
	}

}
