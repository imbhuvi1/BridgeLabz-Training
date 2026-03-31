package scenario_based.DigitalWalletSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User u1 = new User(1, "Rahul");
        User u2 = new User(2, "Amit");

        Wallet w1 = new Wallet(1000);
        Wallet w2 = new Wallet(500);

        System.out.print("Enter Transfer Amount: ");
        double amount = sc.nextDouble();

        System.out.println("Choose Transfer Type:");
        System.out.println("1. Bank Transfer");
        System.out.println("2. Wallet Transfer");
        int choice = sc.nextInt();

        TransferService service;
        if (choice == 1)
            service = new BankTransfer();
        else
            service = new WalletTransfer();

        try {
            service.transfer(w1, w2, amount);
            System.out.println("Transfer Successful");
            System.out.println("Sender Balance: ₹" + w1.getBalance());
            System.out.println("Receiver Balance: ₹" + w2.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
