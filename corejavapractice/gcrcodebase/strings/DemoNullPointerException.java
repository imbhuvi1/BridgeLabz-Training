package gcrcodebase.strings;

import java.util.*;
public class DemoNullPointerException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		//calling method to generate exception
		try {
			generateException();
		}catch (NullPointerException e) {
            System.out.println("Exception generated in generateException() method");
        }
		
		// Calling method to handle exception
		handleException();
		
	}
	public static void generateException() {
		String text = null;
		System.out.println(text.length()); 
	}
	
	public static void handleException() {
		String text = null;
		
		try {
			System.out.println(text.length());
		}catch(NullPointerException e) {
			System.out.println("NullPointerException handled.");
            System.out.println("Reason: " + e);
		}
	}
}
