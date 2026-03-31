package scenario_based.DigitalWalletSystem;

// Custom exception
public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
