package lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListReversExTest {

    @Test
    public void revReturnsNull() {
        ListReversEx<Integer> reverser = new ListReversEx<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        assertNull(reverser.rev(list));
    }

    @Test
    public void revInPlaceDoesNothing() {
        ListReversEx<Integer> reverser = new ListReversEx<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.addLastNode(1);
        list.addLastNode(2);
        reverser.revInPlace(list);
        assertEquals("1 2 ", list.toString());
    }
}
