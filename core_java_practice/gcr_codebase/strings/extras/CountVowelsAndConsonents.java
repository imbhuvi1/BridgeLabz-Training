package gcr_codebase.strings.extras;

import java.util.*;
public class CountVowelsAndConsonents {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string: ");
		String str = sc.next();
		
		int vowel = 0;
		int consonant = 0;
		
		for(char ch : str.toCharArray()) {
			
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowel++;
			
			else consonant++;
		}
		
		System.out.println("No. of vowels : " + vowel);
		System.out.println("No. of consonants: " + consonant);
		sc.close();
	}

}
