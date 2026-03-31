package scenario_based.SmartShelf;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SmartShelf shelf = new SmartShelf(10);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Book Title: ");
                shelf.addBook(new Book(sc.nextLine()));
            } else if (choice == 2) {
                shelf.display();
            } else {
                System.exit(0);
            }
        }
    }
}
