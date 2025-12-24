package gcrcodebase.controlflow;

import java.util.Scanner;

public class MultiplesBelow100For {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number (<100): ");
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0)
                    System.out.println(i);
            }
        } else {
            System.out.println("Invalid input");
        }

        sc.close();
    }
}
