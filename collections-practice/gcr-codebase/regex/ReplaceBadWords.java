package gcr_codebase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceBadWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String badWords[] = {"damn", "stupid"};
		String regex = "\\b(?i)("+String.join("|", badWords) + ")\\b";
		Pattern pattern = Pattern.compile(regex);
		String text = sc.nextLine();
		Matcher matcher = pattern.matcher(text);
		String ans = matcher.replaceAll("****");
		System.out.println(ans);
	}

}
