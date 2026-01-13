package scenario_based.DigitalWalletSystem;

// Transaction entity
public class Transaction {

    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public void display() {
        System.out.println(type + " : ₹" + amount);
    }
}
