package scenario_based.OnlineBankingSystem;

public class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void calculateInterest() {
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nAccount Type  : Current";
    }
}
