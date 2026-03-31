package gcr_codebase.this_static_final_keywords;

public class BankAccount {
	
	// Static variable shared across all accounts
	private static String bankName = "State Bank of India";
	private static int totalAccounts = 0;

	// Final variable to ensure account number cannot be changed once assigned
	private final String accountNumber;
	private String accountHolderName;
	private double balance;
	
	// Constructor using this to avoid ambiguity
	public BankAccount(String accountHolderName, String accountNumber, double balance) {
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber; // Final variable assigned only once
		this.balance = balance;
		totalAccounts++; // Increment total accounts with each new account
	}
	
	// Static method to get the total number of accounts
	public static void getTotalAccounts() {
		System.out.println("Total number of accounts: " + totalAccounts);
	}
	
	// Method to display account details
	public void displayAccountDetails() {
		
	// Using instanceof to check if the object is a BankAccount instance
		if (this instanceof BankAccount) {
			System.out.println("Bank Name: " + bankName);
			System.out.println("Account Holder: "+ accountHolderName);
			System.out.println("Account Number: "+ accountNumber);
			System.out.println("Balance: "+ balance);
		} else {
			System.out.println("Invalid account instance.");
		}
	}
	
	// Main method for testing
	public static void main(String[] args) {
		// Create two bank accounts
		BankAccount account1 = new BankAccount("Lynda Princy", "ACC12345", 1000.00);
		BankAccount account2 = new BankAccount("Prince Danish", "ACC67890", 500.00);
		
		// Display account details
		System.out.println("\nAccount 1 Details:");
		account1.displayAccountDetails();
		System.out.println("\nAccount 2 Details:");
		account2.displayAccountDetails();
		
		// Check total accounts
		BankAccount.getTotalAccounts();
		}
	}
