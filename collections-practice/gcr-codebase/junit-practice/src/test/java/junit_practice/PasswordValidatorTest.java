package junit_practice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
	PasswordValidator validator;

	@BeforeEach
	public void setUp() {
		validator = new PasswordValidator();
	}

	@Test
	public void testValidPassword() {
		assertTrue(validator.isValid("Password1"));
		assertTrue(validator.isValid("Password123"));
		assertTrue(validator.isValid("PASSWORD1"));
	}

	@Test
	public void testInvalidPassword() {
		assertFalse(validator.isValid("Pass1"));
		assertFalse(validator.isValid("password1"));
		assertFalse(validator.isValid("Password"));
		assertFalse(validator.isValid(null));
	}
}