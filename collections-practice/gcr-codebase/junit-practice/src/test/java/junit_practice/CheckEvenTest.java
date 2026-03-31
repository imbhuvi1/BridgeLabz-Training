package junit_practice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CheckEvenTest {
	CheckEven checkEven;

	@BeforeEach
	public void setUp() {
		checkEven = new CheckEven();
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 7, 9 })
	public void testIsEven(int n) {
		if (n % 2 == 0) {
			assertTrue(checkEven.isEven(n), n + " is even");
		} else {
			assertFalse(checkEven.isEven(n), n + " is odd");
		}
	}
}
