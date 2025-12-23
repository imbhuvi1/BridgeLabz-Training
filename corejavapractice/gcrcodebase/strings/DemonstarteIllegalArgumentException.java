package gcrcodebase.strings;

import java.util.*;
public class DemonstarteIllegalArgumentException {
	//System.out.println();
	
	//Method to generate the Exception
	public static void generateException(String text) {
		System.out.println("Using the subString() incorrectly to cause exception: ");
		String result = text.substring(4,2); 
		System.out.println(result);
	}
	
	//Method to handle Exception
	public static void handleExeption(String text) {
		try {
			System.out.println("Using the subString() incorrectly to cause exception: ");
			System.out.println(text.substring(3,2));
		}catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException handled");
			System.out.print("Reason" + e);
		}
	}
	
	//Main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking user input
		System.out.println("Enter a string of more than 4 letters: ");
		String text = sc.next();
		
		// Calling method that generates exception
        System.out.println("\nCalling method to generate exception:");
		try {
			generateException(text);
		}catch(IllegalArgumentException e) {
			System.out.println("Exception occurred and program stopped abruptly: " + e);
		}
		
		// Calling method that handles exception
		System.out.println("\nCalling method to handle exception:");
		handleExeption(text);
		
		sc.close();
		
		
		
		
		
	}

}
