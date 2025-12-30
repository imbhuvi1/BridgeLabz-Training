
import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //taking height and age as inpput of Amar, Akbar and Anthony
        System.out.print("Enter Amar's age and height: ");
        int amarAge = sc.nextInt();
        int amarHeight = sc.nextInt();

        System.out.print("Enter Akbar's age and height: ");
        int akbarAge = sc.nextInt();
        int akbarHeight = sc.nextInt();

        System.out.print("Enter Anthony's age and height: ");
        int anthonyAge = sc.nextInt();
        int anthonyHeight = sc.nextInt();

        // Youngest person among them
        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        if (youngestAge == amarAge)
            System.out.println("Amar is the youngest");
        else if (youngestAge == akbarAge)
            System.out.println("Akbar is the youngest");
        else
            System.out.println("Anthony is the youngest");

        // Finding the Tallest person
        int tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        if (tallestHeight == amarHeight)
            System.out.println("Amar is the tallest");
        else if (tallestHeight == akbarHeight)
            System.out.println("Akbar is the tallest");
        else
            System.out.println("Anthony is the tallest");

        sc.close();
    }
}
