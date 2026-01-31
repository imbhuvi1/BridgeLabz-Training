package gcr_codebase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllCapitalizedWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String regex = "\\b[A-Z][a-z]*\\b";
		Pattern pattern = Pattern.compile(regex);
		String text = sc.nextLine();
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
