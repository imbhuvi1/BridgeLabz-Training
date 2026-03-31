import java.util.*;

// Exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Abstract account class
abstract class Account {
    int accountNumber;
    String holderName;
    double balance;
    List<String> transactionHistory = new ArrayList<>();

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public abstract double calculateInterest();

    public synchronized void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited " + amount);
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn " + amount);
    }

    public double getBalance() {
        return balance;
    }
}

// Savings account
class SavingsAccount extends Account {
    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}

// Current account
class CurrentAccount extends Account {
    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return balance * 0.02;
    }
}

// Bank service interface
interface BankService {
    void createAccount(Account account);
    double checkBalance(int accountNumber);
    void transferMoney(int fromAccount, int toAccount, double amount)
            throws InsufficientBalanceException;
    List<String> getTransactionHistory(int accountNumber);
}

// Bank service implementation
class BankServiceImpl implements BankService {

    Map<Integer, Account> accounts = new HashMap<>();

    public void createAccount(Account account) {
        accounts.put(account.accountNumber, account);
    }

    public double checkBalance(int accountNumber) {
        return accounts.get(accountNumber).getBalance();
    }

    public synchronized void transferMoney(int fromAccount, int toAccount, double amount)
            throws InsufficientBalanceException {

        Account sender = accounts.get(fromAccount);
        Account receiver = accounts.get(toAccount);

        sender.withdraw(amount);
        receiver.deposit(amount);

        sender.transactionHistory.add("Transferred " + amount + " to account " + toAccount);
        receiver.transactionHistory.add("Received " + amount + " from account " + fromAccount);
    }

    public List<String> getTransactionHistory(int accountNumber) {
        return accounts.get(accountNumber).transactionHistory;
    }
}

// Main application with user input
public class OnlineBankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();

        while (true) {
            System.out.println("\n1 Create Account");
            System.out.println("2 Check Balance");
            System.out.println("3 Transfer Money");
            System.out.println("4 Transaction History");
            System.out.println("5 Exit");
            System.out.print("Enter choice ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter account number ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter holder name ");
                    String name = sc.nextLine();

                    System.out.print("Enter initial balance ");
                    double balance = sc.nextDouble();

                    System.out.print("Enter account type Savings or Current ");
                    String type = sc.next();

                    Account account;
                    if (type.equalsIgnoreCase("Savings")) {
                        account = new SavingsAccount(accNo, name, balance);
                    } else {
                        account = new CurrentAccount(accNo, name, balance);
                    }

                    bankService.createAccount(account);
                    System.out.println("Account created successfully");
                    break;

                case 2:
                    System.out.print("Enter account number ");
                    int checkAcc = sc.nextInt();
                    System.out.println("Balance " + bankService.checkBalance(checkAcc));
                    break;

                case 3:
                    System.out.print("Enter sender account number ");
                    int from = sc.nextInt();

                    System.out.print("Enter receiver account number ");
                    int to = sc.nextInt();

                    System.out.print("Enter amount ");
                    double amount = sc.nextDouble();

                    try {
                        bankService.transferMoney(from, to, amount);
                        System.out.println("Transfer successful");
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter account number ");
                    int histAcc = sc.nextInt();

                    List<String> history = bankService.getTransactionHistory(histAcc);
                    for (String h : history) {
                        System.out.println(h);
                    }
                    break;

                case 5:
                    System.out.println("Thank you");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
