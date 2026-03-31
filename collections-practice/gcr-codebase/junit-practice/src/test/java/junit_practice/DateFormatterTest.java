package junit_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {
	DateFormatter formatter;

	@BeforeEach
	void setUp() {
		formatter = new DateFormatter();
	}

	@Test
	void testValidDates() {
		assertEquals("31-01-2026", formatter.formatDate("2026-01-31"));
		assertEquals("01-01-2026", formatter.formatDate("2026-01-01"));
		assertEquals("19-12-2003", formatter.formatDate("2003-12-19"));
	}

	@Test
	void testInvalidDates() {
		assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("31/01/2026"));
		assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("2026-31-01"));
		assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("abcd-ef-gh"));
		assertThrows(NullPointerException.class, () -> formatter.formatDate(null));
	}
}
