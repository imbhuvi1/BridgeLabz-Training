package junit_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
	StringUtils su;
	
	@BeforeEach
	public void start() {
		su = new StringUtils();	
	}
	
	@Test
	public void testReverse() {
		assertEquals("abc", su.reverse("cba"));
		assertEquals("a", su.reverse("a"));
		assertEquals("", su.reverse(""));
		assertNull(su.reverse(null));
	}
	
	@Test
	public void testIsPalindrome() {
		assertTrue(su.isPalindrome("aaa"));
		assertTrue(su.isPalindrome("a"));
		assertTrue(su.isPalindrome(""));
		assertFalse(su.isPalindrome("abc"));
		assertFalse(su.isPalindrome(null));
	}
	
	@Test
	public void testUpperCase() {
		assertEquals("HELLO", su.toUpperCase("hello"));
		assertEquals("A", su.toUpperCase("A"));
		assertEquals("", su.toUpperCase(""));
		assertNull(su.toUpperCase(null));
	}
}
