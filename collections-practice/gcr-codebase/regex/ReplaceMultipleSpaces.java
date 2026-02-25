package gcr_codebase.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceMultipleSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String regex = "\\s{2,}";
		
		Pattern pattern = Pattern.compile(regex);
		String text = sc.nextLine();
		Matcher matcher = pattern.matcher(text);
		String ans = matcher.replaceAll(" ");
		System.out.println(ans);
	}
}
