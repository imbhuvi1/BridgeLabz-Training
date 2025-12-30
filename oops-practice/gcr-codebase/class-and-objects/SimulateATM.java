class BankAccount {
	String accountHolder;
	private String accountNumber;
	private double balance;

	BankAccount(String accountHolder, String accountNumber, double balance) {
		// TODO Auto-generated constructor stub
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public void depositAmount(double amount) {
		displayCurrentBalance();
		System.out.println("Deposited: " + amount);
		balance += amount;
		displayCurrentBalance();
		System.out.println();
	}

	public double withdrawAmount(double amount) {
		displayCurrentBalance();
		System.out.println("Withdraw Amount: " + amount);
		if (amount <= balance) {
			balance = balance - amount;
			displayCurrentBalance();
			System.out.println();
			return amount;
		} else {
			System.out.println("Insufficient balance");
			System.out.println();
			return 0;
		}
	}

	public void displayCurrentBalance() {
		System.out.println("Current balance: " + balance);
	}
}

public class SimulateATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount b1 = new BankAccount("Govind", "1122311312", 700);
		b1.depositAmount(200);
		b1.withdrawAmount(100);
		b1.withdrawAmount(1000);

	}

}