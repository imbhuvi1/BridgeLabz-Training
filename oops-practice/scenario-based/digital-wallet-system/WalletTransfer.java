package scenario_based.DigitalWalletSystem;

// Wallet transfer logic
public class WalletTransfer implements TransferService {

    @Override
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        from.withdrawMoney(amount);
        to.addMoney(amount - 10); // wallet charge
    }
}
