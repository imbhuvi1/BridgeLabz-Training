//base class
class BankAccount {
	String accountNumber;
	double balance;

	//constructor of BankAccout
	public BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}	
}

//subclass SavingAccount extending superclass BankAccount
class SavingAccount extends BankAccount {
	double interestRate;

	//constructor of SavingAccount
	public SavingAccount(String accountNumber, double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}
	
	//method to display account type and other details
	void displayAccountType() {
		System.out.println("Savings Account");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: "+balance);
		System.out.println("Interest Rate: "+interestRate);
	}

}
//subclass CheckingAccount extending superclass BankAccount
class CheckingAccount extends BankAccount {
	double witthdrawalLimit;
	
	//constructor of CheckingAccount
	public CheckingAccount(String accountNumber, double balance, double witthdrawalLimit) {
		super(accountNumber, balance);
		this.witthdrawalLimit = witthdrawalLimit;
	}
	
	//method to display account type and other details
	void displayAccountType() {
		System.out.println("\nChecking Account");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: "+balance);
		System.out.println("Withdrawal Limit: "+witthdrawalLimit);
	}
}
//subclass FixedDepositAccount extending superclass BankAccount
class FixedDepositAccount extends BankAccount {
	//constructor of FixedDepositAccount
	public FixedDepositAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}
	
	//method to display account type and other details
	void displayAccountType() {
		System.out.println("\nFixed Deposit Account");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: "+balance);
	}
}

//class having main method
public class BankAccountTypes {
	public static void main(String[] args) {
		//creating object of each subclass
		SavingAccount obj1 = new SavingAccount("9843876199427", 20000.23, 10.23);
		CheckingAccount obj2 = new CheckingAccount("9843876199427", 20000.23, 15000);
		FixedDepositAccount obj3 = new FixedDepositAccount("9843876199427", 20000.23);
		
		//calling method of each subclass using the object created.
		obj1.displayAccountType();
		obj2.displayAccountType();
		obj3.displayAccountType();
	}
}