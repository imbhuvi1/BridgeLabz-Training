/*
 2. Scenario: Create a program that analyzes a given paragraph of text. Implement the following
functionalities:
● Count the number of words in the paragraph.
● Find and display the longest word.
● Replace all occurrences of a specific word with another word (case-insensitive).
● Handle edge cases like empty strings or paragraphs with only spaces.
*/

import java.util.*;
public class SentenceFormatter2 {

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
				if((i+1)<str.length() && str.charAt(i + 1) != ' ') {
					result.append(' ');
				}
			}
		}
		return result.toString().trim();
	}
	
	//method to count the number of words
	public static int countWords(String str) {
		String[] words = str.split("\\s+");
		return words.length;
	}
	
	//method to find the longest word
	public static String findLongestWord(String str) {
		
		String[] tempWords = str.split("\\s+");
		
		int largest = 0;
		int getIndex = 0;
		for(int i=0; i<tempWords.length; i++) {
			if(tempWords[i].length()>largest) {
				largest = tempWords[i].length();
				getIndex = i;
			}
		}
		return tempWords[getIndex];
	}
	
	//method to replace all occurrences of a word by another user entered word.
	public static String replaceWord(String wordToBeReplaced,String wordToReplaceBy,String para) {
		System.out.println("\nThe paragraph before replacing the word is: \n"+para);
		
		para = para.trim().replaceAll("\\s+", " ");
		String[] wordsArray = para.split("\\s+");
		
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<wordsArray.length; i++) {
			if(wordsArray[i].equalsIgnoreCase(wordToBeReplaced)) {
				result.append(wordToReplaceBy);
			}else {
				result.append(wordsArray[i]);
			}
			result.append(' ');
		}
		return result.toString().trim();
	}
	
	//main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the paragraph: ");
		String paragraph = sc.nextLine();
		
		if(paragraph.isEmpty()) {
			System.out.println("Paragraph is empty! Enter again");
			sc.close();
			return;
		}
		String str = formatParagraph(paragraph);
		System.out.println("The formatted paragraph is: \n"+str);
		
		System.out.println("The number of words are: \n"+countWords(str));
		
		String longestWord = findLongestWord(str);
		
		System.out.println("The Longest word is: \n"+longestWord);
		
		System.out.println("Enter a word you want to replace in paragraph: ");
		String wordToBeReplaced = sc.next();
		
		System.out.println("Enter a word you want to replace by paragraph: ");
		String wordToReplaceBy = sc.next();
		
		System.out.println("The paragraph after replacing the word: \n"+replaceWord(wordToBeReplaced, wordToReplaceBy, str));
		sc.close();

	}

}
