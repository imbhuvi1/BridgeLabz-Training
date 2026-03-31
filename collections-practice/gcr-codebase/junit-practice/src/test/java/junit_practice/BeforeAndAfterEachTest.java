package junit_practice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeforeAndAfterEachTest {
	BeforeAndAfterEach db;

	@BeforeEach
	public void setUp() {
		db = new BeforeAndAfterEach();
		db.connect();
	}

	@AfterEach
	public void tearDown() {
		db.disconnect();
	}

	@Test
	public void testIsConnected() {
		assertTrue(db.isConnected(), "Database is connected");
	}

	@Test
	public void testIsDisconnected() {
		db.disconnect();
		assertFalse(db.isConnected(), "Database is disconnected");
	}
}