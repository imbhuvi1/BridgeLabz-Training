/*
1. Scenario: A text editing tool receives poorly formatted input from users.
Your task is to auto-correct formatting by fixing spacing and capitalizing the first letter of each sentence.
Problem:
Write a method that takes a paragraph as input and returns a corrected version with:
● One space after punctuation,
● Capital letter after period/question/exclamation marks,
● Trimmed extra spaces. 
*/

import java.util.*;
public class SentenceFormatter1 {

	public static String formatParagraph(String str) {
		
		//trim leading and trailing spaces and replacing extra spaces with a single space
		str= str.trim().replaceAll("\\s+", " ");
		
		
		StringBuilder result = new StringBuilder();
		boolean capitalizeNext = true;
		
		//looping through the paragraph and accessing each character
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			
			//block to capitalize the character if it is a letter or based on a capitalizeNext variable
			if(capitalizeNext && Character.isLetter(ch)) {
				result.append(Character.toUpperCase(ch));
				capitalizeNext = false;
			}else {
				result.append(ch);
			}
			
			//marking the value of capitalize as true to make next character capital after '.', '?', '!' 
			if(ch=='.' || ch=='?' || ch=='!') {
				capitalizeNext = true;
				
				//checking if we need to add spaces or not
				if(str.charAt(i + 1) != ' ' && (i+1)<str.length()) {
					result.append(' ');
				}
			}
		}
		return result.toString().trim();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the paragraph: ");
		String paragraph = sc.nextLine();
		
		System.out.println("The formatted paragraph is: \n"+formatParagraph(paragraph));		
		sc.close();

	}

}
