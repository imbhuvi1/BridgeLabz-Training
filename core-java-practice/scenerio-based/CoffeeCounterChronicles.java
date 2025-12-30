package scenerio_based;

import java.util.*;
public class CoffeeCounterChronicles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final double GST_RATE = 0.05; //5% GST;
		
		while(true) {
			System.out.println("Enter coffee type (Mocha/Latte/Cappuccino/Espresso) or 'exit' to stop: ");
			String coffeeType = sc.nextLine();
			
			if(coffeeType.equalsIgnoreCase("exit")) {
				System.out.println("Thank you for visiting Ravi's Cafe");
                break;
			}
			
			System.out.println("Enter quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			double price;
			
			switch(coffeeType.toLowerCase()) {
			case "mocha":
				price = 119;
				break;
	
			case "latte":
				price = 169;
				break;
			
			case "cappucino":
				price = 199;
				break;
			
			case "espresso":
				price = 129;
				break;
			
				
			default:
				System.out.println("Invalid coffee type!");
                continue;
			}
			
			//calculating the bill now
			double total = price * quantity;
			double gst = total * GST_RATE;
			double finalBill = total + gst;
			
			System.out.println("Base Amount: Rs." + total);
            System.out.println("GST (5%): Rs." + gst);
            System.out.println("Total Bill: Rs." + finalBill);
		}
		
		
	}

}
