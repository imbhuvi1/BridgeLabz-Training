package junit_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	Calculator c;

	@BeforeEach
	public void start() {
		c = new Calculator();
	}

	@Test
	void testAdd() {
		assertEquals(5, c.add(2, 3));
	}

	@Test
	void testSubtract() {
		assertEquals(1, c.subtract(3, 2));
	}

	@Test
	void testMultiply() {
		assertEquals(15, c.multiply(5, 3));
	}

	@Test
	void testDivide() {
		assertEquals(5, c.add(2, 3));
	}

	@Test
	void testDivideByZero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			c.divide(5, 0);
		});
		assertEquals("Cannot divide by 0", exception.getMessage());
	}
}
