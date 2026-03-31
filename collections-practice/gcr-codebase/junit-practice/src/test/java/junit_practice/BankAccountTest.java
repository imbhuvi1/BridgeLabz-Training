package junit_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
	BankAccount bankAccount;

	@BeforeEach
	public void setUp() {
		bankAccount = new BankAccount(1000);
	}

	@Test
	public void testDeposit() {
		bankAccount.deposit(500);
		assertEquals(1500, bankAccount.getBalance());
	}

	@Test
	public void testWithdraw() {
		bankAccount.withdraw(500);
		assertEquals(500, bankAccount.getBalance());
	}

	@Test
	public void testInsufficientBalance() {
		assertThrows(IllegalArgumentException.class, () -> {
			bankAccount.withdraw(1100);
		});
	}

	@Test
	public void testIllegalAmount() {
		assertThrows(IllegalArgumentException.class, () -> {
			bankAccount.deposit(-100);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			bankAccount.withdraw(-100);
		});
	}
}