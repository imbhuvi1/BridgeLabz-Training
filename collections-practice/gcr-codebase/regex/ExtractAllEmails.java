package gcr_codebase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllEmails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String regex = "[A-Za-z]+([._][A-Za-z0-9])*@([A-Za-z]+([._][A-Za-z0-9])*)\\.[A-Za-z]{2,}";
		
		Pattern pattern = Pattern.compile(regex);
		String text = sc.nextLine();
		Matcher matcher = pattern.matcher(text);
		
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
