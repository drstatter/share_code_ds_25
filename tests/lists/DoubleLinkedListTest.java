package lists;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    private DoubleLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new DoubleLinkedList<>();
    }

    @Test
    public void newListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }

    @Test
    public void addLastAppendsToEnd() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(3, list.getSize());
        assertFalse(list.isEmpty());
        assertEquals("10 20 30 ", list.toString());
    }

    @Test
    public void addFirstPrependsToStart() {
        list.addLast(10);
        list.addFirst(5);
        list.addFirst(1);

        assertEquals(3, list.getSize());
        assertEquals("1 5 10 ", list.toString());
    }

    @Test
    public void addInInsertsAfterGivenNode() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        DoubleNode<Integer> node20 = list.findNode(20);

        list.addIn(node20, 25);

        assertEquals(4, list.getSize());
        assertEquals("10 20 25 30 ", list.toString());
    }

    @Test
    public void findNodeReturnsMatchingNode() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        DoubleNode<Integer> found = list.findNode(20);

        assertNotNull(found);
        assertEquals(20, (int) found.getData());
    }

    @Test
    public void findNodeReturnsNullWhenMissing() {
        list.addLast(10);

        assertNull(list.findNode(99));
    }

    @Test
    public void deleteExistingValueRemovesIt() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        boolean result = list.delete(20);

        assertTrue(result);
        assertEquals(2, list.getSize());
        assertEquals("10 30 ", list.toString());
        assertNull(list.findNode(20));
    }

    @Test
    public void deleteMissingValueReturnsFalse() {
        list.addLast(10);

        assertFalse(list.delete(99));
        assertEquals(1, list.getSize());
    }

    @Test
    public void removeHeadUpdatesHeadAndSize() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        DoubleNode<Integer> head = list.findNode(10);

        assertTrue(list.remove(head));
        assertEquals(2, list.getSize());
        assertEquals("20 30 ", list.toString());
    }

    @Test
    public void removeTailUpdatesTailAndSize() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        DoubleNode<Integer> tail = list.findNode(30);

        assertTrue(list.remove(tail));
        assertEquals(2, list.getSize());
        assertEquals("10 20 ", list.toString());
    }

    @Test
    public void removeMiddleUpdatesLinks() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        DoubleNode<Integer> middle = list.findNode(20);

        assertTrue(list.remove(middle));
        assertEquals(2, list.getSize());
        assertEquals("10 30 ", list.toString());
    }

    @Test
    public void removeOnlyElementEmptiesList() {
        list.addLast(10);
        DoubleNode<Integer> onlyNode = list.findNode(10);

        assertTrue(list.remove(onlyNode));
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
        assertEquals("", list.toString());
    }

    @Test
    public void removeNullNodeReturnsFalse() {
        list.addLast(10);

        assertFalse(list.remove(null));
        assertEquals(1, list.getSize());
    }

    @Test
    public void removeOnEmptyListReturnsFalse() {
        assertFalse(list.remove(new DoubleNode<>(null, null, 1)));
    }

    @Test
    public void iteratorTraversesAllElementsInOrder() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        Iterator<DoubleNode<Integer>> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(10, (int) iterator.next().getData());
        assertEquals(20, (int) iterator.next().getData());
        assertEquals(30, (int) iterator.next().getData());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void toStringOnEmptyListIsEmptyString() {
        assertEquals("", list.toString());
    }
}
