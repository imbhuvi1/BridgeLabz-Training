package scenario_based.OnlineBankingSystem;

public class Account {

    protected int accountNumber;
    protected String accountHolder;
    protected double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }
    
    @Override
    public String toString() {
        return "Account Number : " + accountNumber +
               "\nHolder Name   : " + accountHolder +
               "\nBalance       : " + balance;
    }
}

