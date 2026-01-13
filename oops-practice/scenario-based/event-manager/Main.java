package scenario_based.EventManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tickets: ");
        int n = sc.nextInt();

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price: ");
            tickets[i] = new Ticket(sc.nextDouble());
        }

        QuickSort.sort(tickets, 0, n - 1);

        System.out.println("\nSorted Ticket Prices:");
        for (Ticket t : tickets) {
            System.out.println(t.price);
        }
    }
}
