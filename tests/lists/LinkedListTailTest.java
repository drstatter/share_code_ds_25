package lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTailTest {

    private LinkedListTail<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedListTail<>();
    }

    @Test
    public void newListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void addAppendsToEnd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals(1, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
    }

    @Test
    public void getOutOfBoundsThrows() {
        list.add(1);
        try {
            list.get(5);
            fail("expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
        }
    }

    @Test
    public void removeByIndexHead() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, (int) list.remove(0));
        assertEquals(2, list.size());
        assertEquals(2, (int) list.get(0));
    }

    @Test
    public void removeByIndexTail() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, (int) list.remove(2));
        assertEquals(2, list.size());
    }

    @Test
    public void removeDataFindsAndRemovesNonHeadElement() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, (int) list.removeData(2));
        assertEquals(2, list.size());
    }

    @Test
    public void removeDataOnHeadDecrementsSizeButReturnsNull() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertNull(list.removeData(1));
        assertEquals(2, list.size());
        assertEquals(2, (int) list.get(0));
    }

    @Test
    public void removeDataReturnsNullWhenMissing() {
        list.add(1);
        assertNull(list.removeData(99));
    }

    @Test
    public void toStringStartsWithElementChain() {
        list.add(1);
        list.add(2);
        assertTrue(list.toString().startsWith("1 -> 2 -> null"));
    }
}
