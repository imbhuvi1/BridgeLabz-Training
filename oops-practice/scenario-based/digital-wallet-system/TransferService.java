package scenario_based.DigitalWalletSystem;

// Abstraction
public interface TransferService {

    void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException;
}
