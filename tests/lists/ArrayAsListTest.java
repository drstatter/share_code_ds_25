package lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayAsListTest {

    private ArrayAsList list;

    @Before
    public void setUp() {
        list = new ArrayAsList(3);
    }

    @Test
    public void newListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void addIncreasesSizeUntilCapacity() {
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void addBeyondCapacityFails() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertFalse(list.add(4));
        assertEquals(3, list.size());
    }

    @Test
    public void containsAlwaysReturnsFalse() {
        list.add(1);
        assertFalse(list.contains(1));
    }
}
