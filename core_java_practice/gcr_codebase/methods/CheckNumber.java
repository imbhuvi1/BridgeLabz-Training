package gcr_codebase.methods;

import java.util.*;
public class CheckNumber {

	
	public static void checkNumber(int number) {
		if(number>0) {
			System.out.println("The number '"+number+"' is positive.");;
		}else if(number<0) {
			System.out.println("The number '"+number+"' is negative.");
		}else {
			System.out.println("The number '"+number+"' is zero.");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//take number input
		System.out.println("Enter the number: ");
		int number = sc.nextInt();
		
		//displaying the number is positive, negative or zero by calling the method
		checkNumber(number);
		
		sc.close();
	}

}
