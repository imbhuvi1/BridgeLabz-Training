package scenario_based.OnlineBankingSystem;

public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void calculateInterest() {
        balance += balance * 0.04;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nAccount Type  : Savings";
    }
}