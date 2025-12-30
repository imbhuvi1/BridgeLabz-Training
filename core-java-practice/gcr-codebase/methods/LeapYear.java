package gcr_codebase.methods;

import java.util.*;

public class LeapYear {

    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //input
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        //calling the method and displaying
        if (isLeapYear(year))
            System.out.println("Year is a Leap Year");
        else
            System.out.println("Year is not a Leap Year");

        sc.close();
    }
}
