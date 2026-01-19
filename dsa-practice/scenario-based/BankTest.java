package scenario_based;

//Abstract base class
abstract class BankAccount {
 private final String accountNumber; // immutable
 private final double balance;        // immutable

 public BankAccount(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 protected double getBalance() {
     return balance;
 }

 // Polymorphic method
 public abstract double calculateFee();
}

//Savings Account implementation
class SavingsAccount extends BankAccount {

 public SavingsAccount(String accountNumber, double balance) {
     super(accountNumber, balance);
 }

 @Override
 public double calculateFee() {
     return getBalance() * 0.005; // 0.5% fee
 }
}

//Checking Account implementation
class CheckingAccount extends BankAccount {

 public CheckingAccount(String accountNumber, double balance) {
     super(accountNumber, balance);
 }

 @Override
 public double calculateFee() {
     return getBalance() < 1000 ? 1.0 : 0.0; // flat fee rule
 }
}

//Test class
public class BankTest {
 public static void main(String[] args) {
     BankAccount savings = new SavingsAccount("12345", 1000.0);
     System.out.printf("%.2f%n", savings.calculateFee()); // 5.00
 }
}
