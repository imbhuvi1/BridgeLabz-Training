package gcr_codebase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractProgmmingLanguages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String languages[] = { "Java", "Python", "Go", "Javascript" };
		String text = sc.nextLine();
		String regex = "\\b(?i)(" + String.join("|", languages) + ")\\b";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(regex);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
