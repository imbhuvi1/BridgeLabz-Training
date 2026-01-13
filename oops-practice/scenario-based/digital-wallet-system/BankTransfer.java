package scenario_based.DigitalWalletSystem;

// Bank transfer logic
public class BankTransfer implements TransferService {

    @Override
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        from.withdrawMoney(amount);
        to.addMoney(amount);
    }
}
