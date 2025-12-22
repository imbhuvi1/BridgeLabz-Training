package gcrcodebase.strings;

import java.util.*;
import gcrcodebase.strings.CompareStrings;
public class CreateStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//What if user enters a line ?
		
		//taking string input
		System.out.println("Enter the string: ");
		String str = sc.next();
		
		//taking start and end index to find substring
		System.out.println("Enter the start index: ");
		int start = sc.nextInt();
		
		System.out.println("Enter the end index: ");
		int end = sc.nextInt();
		
		//finding substring using the charAt(index) method
		String substring1 = SubstringUsingCharAt(str, start, end);
		System.out.println("Substring using the 'charAt' method is: " + substring1);
		
		//finding substring using the substring(start, end) method
		String substring2 = str.substring(start, end+1);
		System.out.println("Substring using the 'Substring' method is: " + substring2);
		
		//comparing both strings using the charAt mehtod as used in 
		if(CompareUsingCharAt(substring1,substring2)) {
			System.out.println("Strings are equal");
		}else {
			System.out.println("Strings are not equal");
		}
		sc.close();
		
	}
	public static boolean CompareUsingCharAt(String string1, String string2) {
		//comparing using "charAt"
		if(string1.length()!=string2.length()) {
			return false;
		}
		else {
			for(int i=0; i<string1.length(); i++) {
				if(string1.charAt(i)!=string2.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
	public static String SubstringUsingCharAt(String str, int start, int end) {
		String temporaryString = "";
		for(int i=0; i<str.length(); i++) {
			if(i>=start && i<end) {
				temporaryString += str.charAt(i);
			}
			if(i==end) {
				temporaryString += str.charAt(i);
				break;
			}
		}
		return temporaryString;
	}

}
