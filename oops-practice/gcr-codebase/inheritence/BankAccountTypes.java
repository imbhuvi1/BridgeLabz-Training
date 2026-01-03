class BankAccount {
	int accountNumber;
	double balance;

	public BankAccount(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
}

class SavingAccount extends BankAccount {
	double interestRate;

	public SavingAccount(int accountNumber, double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}
	
	void displayAccountType() {
		System.out.println("Savings Account");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: "+balance);
		System.out.println("Interest Rate: "+interestRate);
	}

}

class CheckingAccount extends BankAccount {
	double witthdrawalLimit;
	
	public CheckingAccount(int accountNumber, double balance, double witthdrawalLimit) {
		super(accountNumber, balance);
		this.witthdrawalLimit = witthdrawalLimit;
	}
	
	void displayAccountType() {
		System.out.println("Checking Account");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: "+balance);
		System.out.println("Withdrawal Limit: "+witthdrawalLimit);
	}
}

class FixedDepositAccount extends BankAccount {
	public FixedDepositAccount(int accountNumber, double balance) {
		super(accountNumber, balance);
	}
	
	void displayAccountType() {
		System.out.println("Checking Account");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: "+balance);
	}
}

public class BankAccountTypes {
	public static void main(String[] args) {
		
	}
}
