package scenario_based.OnlineBankingSystem;

public class BankServiceImpl implements BankService{
	
	public void transfer(Account from, Account to, double amount) throws InsufficientBalanceException{
		from.withdraw(amount);
		to.deposit(amount);
	}
}
