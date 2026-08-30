package lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListRevsTest {

    @Test
    public void reverseReturnsNewReversedList() {
        ListRevs<Integer> listRevs = new ListRevs<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.addLastNode(1);
        list.addLastNode(2);
        list.addLastNode(3);

        LinkedList<Integer> reversed = listRevs.reverse(list);

        assertEquals("3 2 1 ", reversed.toString());
        assertEquals("1 2 3 ", list.toString());
    }

    @Test
    public void reverseInPlaceMutatesOriginalList() {
        ListRevs<Integer> listRevs = new ListRevs<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.addLastNode(1);
        list.addLastNode(2);
        list.addLastNode(3);

        listRevs.reverseInPlace(list);

        assertEquals("3 2 1 ", list.toString());
    }
}
