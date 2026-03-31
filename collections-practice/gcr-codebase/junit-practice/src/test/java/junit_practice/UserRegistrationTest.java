package junit_practice;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {
	UserRegistration registration;

	@BeforeEach
	void setUp() {
		registration = new UserRegistration();
	}

	@Test
	void testValidRegistration() {
		assertDoesNotThrow(() -> registration.registerUser("Govind", "govind@gmail.com", "Password123"));
	}

	@Test
	void testInvalidUsername() {
		assertThrows(IllegalArgumentException.class,
				() -> registration.registerUser("", "govind@gmail.com", "Password123"));
		assertThrows(IllegalArgumentException.class,
				() -> registration.registerUser(null, "govind@gmail.com", "Password123"));
	}

	@Test
	void testInvalidEmail() {
		assertThrows(IllegalArgumentException.class,
				() -> registration.registerUser("Govind", "govind.com", "Password123"));
		assertThrows(IllegalArgumentException.class, () -> registration.registerUser("Govind", null, "Password123"));
	}

	@Test
	void testInvalidPassword() {
		assertThrows(IllegalArgumentException.class,
				() -> registration.registerUser("Govind", "govind@gmail.com", "pass"));
		assertThrows(IllegalArgumentException.class,
				() -> registration.registerUser("Govind", "govind@gmail.com", null));
	}
}
