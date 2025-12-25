package gcr_codebase.control_flow;

import java.util.*;
public class SpringSeason {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	//taking user input
    	System.out.println("Enter the month: ");
        int month = sc.nextInt();
        
        System.out.println("Enter the day: ");
        int day = sc.nextInt();

        // Checking spring season condition
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}

