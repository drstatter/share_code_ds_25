package lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListIntTest {

    private LinkedListInt list;

    @Before
    public void setUp() {
        list = new LinkedListInt();
    }

    @Test
    public void addFirstAndAddLastBuildExpectedOrder() {
        list.addLastNode(7);
        list.addFirst(4);
        list.addFirst(3);
        list.addLastNode(8);
        assertEquals("[3, 4, 7, 8]", list.toString());
    }

    @Test
    public void deleteDataReturnsNoFoundWhenMissing() {
        list.addLastNode(7);
        assertEquals(LinkedListInt.NO_FOUND, list.deleteData(99));
    }

    @Test
    public void deleteDataRemovesHead() {
        list.addLastNode(7);
        list.addLastNode(8);
        assertEquals(7, list.deleteData(7));
        assertEquals("[8]", list.toString());
    }

    @Test
    public void deleteDataRemovesMiddleElement() {
        list.addLastNode(7);
        list.addLastNode(8);
        list.addLastNode(9);
        assertEquals(8, list.deleteData(8));
        assertEquals("[7, 9]", list.toString());
    }

    @Test
    public void deleteDataOnEmptyListReturnsNoFound() {
        assertEquals(LinkedListInt.NO_FOUND, list.deleteData(1));
    }
}
