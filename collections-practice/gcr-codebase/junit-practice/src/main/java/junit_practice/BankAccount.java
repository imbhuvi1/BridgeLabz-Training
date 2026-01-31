package junit_practice;

public class BankAccount {
	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Deposit amount must be positive");
		}
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive");
		}
		if (amount > balance) {
			throw new IllegalArgumentException("Insufficient balance");
		}
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
}