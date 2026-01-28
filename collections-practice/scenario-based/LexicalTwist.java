package scenario_based;

import java.util.*;

public class LexicalTwist {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the first word: ");
		String firstWord = sc.nextLine();

		System.out.println("Enter the second word: ");
		String secondWord = sc.nextLine();
		
		 // validations
	    if (firstWord.contains(" ")) {
	        System.out.println(firstWord + " is an invalid word");
	        return;
	    }

	    if (secondWord.contains(" ")) {
	        System.out.println(secondWord + " is an invalid word");
	        return;
	    }
	    
		if (checkReversed(firstWord, secondWord)) {
			System.out.println("\nSecond word is reverse of the first word");

			// reversing the second word
			String reversed = reverseWord(firstWord);
			System.out.println("Reversed first word: " + reversed);

			// converting reversedFirstWord to lower case
			String lowerCased = lowercaseWord(reversed);
			System.out.println("Lowercased word: " + lowerCased);

			// replacing vowels with @
			String replaced = replaceWithSymbol(lowerCased);
			System.out.println("\nTransformed word: " + replaced);

		} else {
			System.out.println("\nSecond word is not reverse of the first word");

			// combining the first and the second word into one
			String combined = (firstWord + "" + secondWord);
			System.out.println("Combined word: " + combined);

			// converting combined to uppercase word
			String upperCased = uppercaseWord(combined);
			System.out.println("Uppercased word: " + upperCased);

			// counting consonants and vowels
			int[] counts = countVowelAndConsonents(upperCased);
			int vowelsCounts = counts[0];
			int consonantsCounts = counts[1];
			System.out.println("Number of vowels: " + vowelsCounts);
			System.out.println("Number of consonants: " + consonantsCounts);

			// evaluation based on counts
			if (vowelsCounts > consonantsCounts) {
				printTwoVowels(upperCased);
			} else if (consonantsCounts > vowelsCounts) {
				printTwoConsonants(upperCased);
			} else {
				System.out.println("Vowels and Consonants are equal.");
			}

		}
	}

	static void printTwoVowels(String str) {
		Set<Character> set = new LinkedHashSet<>();
		for(char c : str.toCharArray()) {
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				set.add(c);
			}
		}
		
		String vowel = "";
		int count = 0;
		for (char c : set) {
            vowel += c;
            count++;
            if(count==2) break;
        }
		System.out.println("\nFirst two non-duplicate vowels are: "+vowel);
	}

	static void printTwoConsonants(String str) {
		Set<Character> set = new LinkedHashSet<>();
		for(char c : str.toCharArray()) {
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				continue;
			}else {
				set.add(c);
			}
		}
		
		String consonant = "";
		int count = 0;
		for (char c : set) {
			consonant += c;
            count++;
            if(count==2) break;
        }
		System.out.println("\nFirst two non-duplicate consonant are: "+consonant);
	}

	static int[] countVowelAndConsonents(String str) {
		int countVowels = 0;
		int countConsonants = 0;

		for (char c : str.toCharArray()) {
			if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				countVowels++;
			} else {
				countConsonants++;
			}
		}
		return new int[] { countVowels, countConsonants };
	}

	static String replaceWithSymbol(String str) {
		String temp = "";
		for (char c : str.toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				temp += '@';
			} else {
				temp += c;
			}
		}
		return temp;
	}

	static String uppercaseWord(String str) {
		String temp = "";
		// A-65, Z-90 //a-97, z-122 //'a'-'A' = 97-65 = 32
		for (char c : str.toCharArray()) {
			if ((int) c >= 97 && (int) c <= 122) {
				temp += (char) (c - 32);
			} else {
				temp += c;
			}
		}
		return temp;
	}

	static String lowercaseWord(String str) {
		String temp = "";
		// A-65, Z-90 //a-97, z-122 //'a'-'A' = 97-65 = 32
		for (char c : str.toCharArray()) {
			if ((int) c >= 65 && (int) c <= 90) {
				temp += (char) (c + 32);
			} else {
				temp += c;
			}
		}
		return temp;
	}

	static String reverseWord(String str) {
		String temp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			temp += str.charAt(i);
		}
		return temp;
	}

	static boolean checkReversed(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		int idx = b.length() - 1;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(idx - i)) {
				return false;
			}
		}
		return true;
	}
}
