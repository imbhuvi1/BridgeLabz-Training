package scenario_based;

import java.util.*;

public class FlipKeyLogicalProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string: ");

		String word = sc.next();

		if (Program.cleanseAndInvert(word) == "") {
			System.out.println("Invalid input.");
		}else System.out.println("\nThe generated key is : " + Program.cleanseAndInvert(word));
	}
}

class Program {
	public static String cleanseAndInvert(String input) {
		if (input.length() < 6) {
			return "";
		}
		for (char c : input.toCharArray()) {
			int asciiValue = (int) c;
			if (c == ' ') {
				return "";
			} else if (asciiValue >= 48 && asciiValue <= 57) {
				return "";
			} else if ((asciiValue >= 32 && asciiValue <= 47) || (asciiValue >= 58 && asciiValue <= 64)
					|| (asciiValue >= 91 && asciiValue <= 96) || (asciiValue >= 123 && asciiValue <= 126)) {
				return "";
			}
		}

		// Converting the input to lowercase.
		String lowercased = input.toLowerCase();

		// Removing all characters whose ASCII values are even numbers.
		String evenAsciiRemoved = "";
		for (char c : lowercased.toCharArray()) {
			int asciiValue = (int) c;
			if (asciiValue % 2 != 0) {
				evenAsciiRemoved += c;
			}
		}
		// Reversing the remaining characters.
		String reversed = "";
		for (int i = evenAsciiRemoved.length() - 1; i >= 0; i--) {
			reversed += evenAsciiRemoved.charAt(i);
		}

		// In the reversed string, converting characters that have even positioned
		// character (0 based index) to upper case.
		String converted = "";
		for (int i = 0; i < reversed.length(); i++) {
			if (i % 2 == 0) {
				converted += Character.toUpperCase(reversed.charAt(i));
			} else {
				converted += reversed.charAt(i);
			}
		}
		return converted;
	}
}
