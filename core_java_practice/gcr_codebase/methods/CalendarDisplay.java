package gcr_codebase.methods;

import java.util.*;

public class CalendarDisplay {

    //Method to get month name using month array
    public static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April","May", "June", "July", "August","September", "October", "November", "December"};
        return months[month - 1];
    }

    //Method to check leap year
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year % 4 == 0;
    }

    //Method to get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year))
            return 29;

        return days[month - 1];
    }

    //Method to get first day of the month using gregorian calendar
    //0 = sunday, 1 = monday, ..., 6 = saturday
    
    public static int getFirstDay(int day,int month, int year) {

    	int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;

        return d0;
    }

    // main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDay(1, month, year);

        // display header
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        //First loop for indentation before day 1
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        //Second loop to print days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);

            //move to next line after saturday 
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        
        sc.close();    }
}
