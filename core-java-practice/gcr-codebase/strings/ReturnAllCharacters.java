
import java.util.*;
public class ReturnAllCharacters {
	static char[] charArrayUserDefined;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//take input 
		System.out.println("Enter the string: ");
		String str = sc.next();
		
		//creating an array to store the characters returned by user defined method of
		charArrayUserDefined = new char[str.length()];
		
		//creating a string to get the characters from user defined method
		String charactersOfString = returnCharacters(str,charArrayUserDefined);
				
		//Displaying string of all characters without using toCharArray
		System.out.println("String with all the characters without using toCharArray(): \n"+ charactersOfString);
		
		//Return characters using the 'toCharArray'
		char[] charArray = str.toCharArray();
		
		//displaying the characters using the 'toCharArray
		String charactersOfString2 = "";
		for(int i=0; i<charArray.length; i++) {
			charactersOfString2 += charArray[i]+"\n";
		}
		System.out.println("String with all the characters using toCharArray():\n"+charactersOfString2);
		
		//comparing both strings using the method
		if(CompareUsingCharAt(charactersOfString, charactersOfString2)) {
			System.out.println("Both strings are equal.");
		}else {
			System.out.println("Strings are not equal.");
		}
		
		//Comparing arrays
		if(Arrays.equals(charArray, charArrayUserDefined)) {
			System.out.println("Both arrays are equal.");
		}else {
			System.out.println("Arrays are not equal.");
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
	public static String returnCharacters(String str, char[] charArrayUserDefined) {
		String temporaryString = "";
		
		for(int i=0; i<str.length(); i++) {
			temporaryString += str.charAt(i)+"\n";
			charArrayUserDefined[i] = str.charAt(i);
		}
		return temporaryString;
	}
}
