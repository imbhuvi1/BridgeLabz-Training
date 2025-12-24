package gcrcodebase.controlflow;

import java.util.Scanner;

public class RocketCountdownWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking countdown starting value
        System.out.print("Enter countdown start number: ");
        int counter = sc.nextInt();

        // Countdown using while loop
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        sc.close();
    }
}