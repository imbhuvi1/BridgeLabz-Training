package junit_practice;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListManagerTest {
	private ListManager listManager;
    private List<Integer> list;

    @BeforeEach
    public void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    @Test
    public void testAddElement() {
        listManager.addElement(list, 5);
        listManager.addElement(list, 10);
        assertEquals(2, list.size());
        assertTrue(list.contains(5));
        assertTrue(list.contains(10));
    }

    @Test
    public void testRemoveElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        listManager.removeElement(list, 2);
        assertEquals(2, list.size());
        assertFalse(list.contains(2));
        listManager.removeElement(list, 5);
        assertEquals(2, list.size());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, listManager.getSize(list));
        list.add(100);
        list.add(200);
        assertEquals(2, listManager.getSize(list));
    }
}
