package junit_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExceptionHandlingTest {
	ExceptionHandling eh;

	@BeforeEach
	public void setUp() {
		eh = new ExceptionHandling();
	}

	@Test
	public void testDivide() {
		assertEquals(4, eh.divide(16, 4));
		assertEquals(10, eh.divide(20, 2));
	}

	@Test
	public void testDivideByZero() {
		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> eh.divide(5, 0));

		assertEquals("Cannot divide by 0", exception.getMessage());
	}
}
