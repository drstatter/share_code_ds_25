package lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void newListIsEmpty() {
        assertNull(list.getHead());
    }

    @Test
    public void addFirstPrependsElements() {
        list.addFirst(10);
        list.addFirst(20);
        assertEquals("20 10 ", list.toString());
    }

    @Test
    public void addLastNodeAppendsElements() {
        list.addLastNode(10);
        list.addLastNode(20);
        list.addLastNode(30);
        assertEquals("10 20 30 ", list.toString());
    }

    @Test
    public void findNodeReturnsMatchingNode() {
        list.addLastNode(10);
        list.addLastNode(20);
        Node<Integer> found = list.findNode(20);
        assertNotNull(found);
        assertEquals(20, (int) found.getData());
    }

    @Test
    public void findNodeReturnsNullWhenMissing() {
        list.addLastNode(10);
        assertNull(list.findNode(99));
    }

    @Test
    public void deleteHeadElement() {
        list.addLastNode(10);
        list.addLastNode(20);
        list.addLastNode(30);
        assertTrue(list.delete(10));
        assertEquals("20 30 ", list.toString());
    }

    @Test
    public void deleteMiddleElement() {
        list.addLastNode(10);
        list.addLastNode(20);
        list.addLastNode(30);
        assertTrue(list.delete(20));
        assertEquals("10 30 ", list.toString());
    }

    @Test
    public void acyclicListReportsNoCycle() {
        list.addLastNode(10);
        list.addLastNode(20);
        list.addLastNode(30);
        assertFalse(list.hasCycle());
    }

    @Test
    public void iteratesInOrder() {
        list.addLastNode(1);
        list.addLastNode(2);
        list.addLastNode(3);
        int expected = 1;
        for (Node<Integer> node : list) {
            assertEquals(expected, (int) node.getData());
            expected++;
        }
    }
}
