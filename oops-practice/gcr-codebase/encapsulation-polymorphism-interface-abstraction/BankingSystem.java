package gcr_codebase.encapsulation_polymorphism_interface_abstraction;

// Interface for loan facility
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount {

    private int accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Encapsulation via getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan Applied for: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 5;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan Applied for: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 3;
    }
}

// Main class
public class BankingSystem {

    // Polymorphic method
    public static void processAccount(BankAccount account) {

        account.displayDetails();
        double interest = account.calculateInterest();
        System.out.println("Interest: " + interest);

        if (account instanceof Loanable) {
            System.out.println("Loan Eligibility: " +
                    ((Loanable) account).calculateLoanEligibility());
        }

        System.out.println("");
    }

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[2];

        accounts[0] = new SavingsAccount(10101, "Rahul", 50000);
        accounts[1] = new CurrentAccount(20202, "Anita", 80000);

        for (int i = 0; i < accounts.length; i++) {
            processAccount(accounts[i]);
        }
    }
}
