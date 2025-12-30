package scenerio_based;

import java.util.*;
public class MetroCardFareDeduction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Smart card balance
		double balance = 500;
		
		final double faeRatePerKm = 1.6;
		
		while(balance>=0) {
			
			//take input
			System.out.println("Enter the distance (in km)? or -1 to exit");
			double distance = sc.nextInt();
			
			//exiting of user enetered -1
			if(distance == -1) {
				break;
			}
			
			//fare for the distance entered
			double currentFare = distance * faeRatePerKm;
			System.out.println("Your Fare for this distance is: "+ currentFare);
			
			//deducting the fare from the balance
			balance -= currentFare;
			
			if(balance<=0) {
				System.out.println("You don't have enough balance in your Smart Card.\nKindly update the balance.");
				break;
			}
			
			System.out.println("\nYour Smart Card Balance left is: "+balance);
			System.out.println();
		}
		
		sc.close();
	}

}
