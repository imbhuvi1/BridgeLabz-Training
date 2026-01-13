package scenario_based.OnlineBankingSystem;

import java.util.*;

public class BankingApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService service = new BankServiceImpl();

        Map<Integer, Account> accounts = new HashMap<>();
        List<Transaction> history = new ArrayList<>();

        int choice;

        do {
            System.out.println("\nONLINE BANKING SYSTEM");
            System.out.println("1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Transfer Money");
            System.out.println("5.View Balance");
            System.out.println("6.View Account Details");
            System.out.println("7.View Transaction History");
            System.out.println("0.Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1: // Create Account
                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double balance = sc.nextDouble();

                        System.out.print("Enter Account Type (1-Savings, 2-Current): ");
                        int type = sc.nextInt();

                        Account acc;
                        if (type == 1) {
                            acc = new SavingsAccount(accNo, name, balance);
                        } else {
                            acc = new CurrentAccount(accNo, name, balance);
                        }

                        accounts.put(accNo, acc);
                        System.out.println("Account created successfully!");
                        break;

                    case 2: // Deposit
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextInt();

                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = sc.nextDouble();

                        accounts.get(accNo).deposit(depositAmount);
                        history.add(new Transaction("Deposit", depositAmount));
                        System.out.println("Amount deposited successfully!");
                        break;

                    case 3: // Withdraw
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextInt();

                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = sc.nextDouble();

                        accounts.get(accNo).withdraw(withdrawAmount);
                        history.add(new Transaction("Withdraw", withdrawAmount));
                        System.out.println("Amount withdrawn successfully!");
                        break;

                    case 4: // Transfer
                        System.out.print("Enter Sender Account Number: ");
                        int fromAcc = sc.nextInt();

                        System.out.print("Enter Receiver Account Number: ");
                        int toAcc = sc.nextInt();

                        System.out.print("Enter Transfer Amount: ");
                        double amount = sc.nextDouble();

                        service.transfer(accounts.get(fromAcc), accounts.get(toAcc), amount);
                        history.add(new Transaction("Transfer", amount));
                        System.out.println("Transfer successful!");
                        break;

                    case 5: // View Balance
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextInt();
                        System.out.println("Balance: " + accounts.get(accNo).getBalance());
                        break;

                    case 6: // View Account Details
                        System.out.print("Enter Account Number: ");
                        accNo = sc.nextInt();
                        System.out.println(accounts.get(accNo));
                        break;

                    case 7: // View Transaction History
                        System.out.println("Transaction History");
                        for (Transaction t : history) {
                            System.out.println(t);
                        }
                        break;

                    case 0:
                        System.out.println("Thank you for using Online Banking System!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Account not found!");
            }

        } while (choice != 0);

        sc.close();
    }
}
