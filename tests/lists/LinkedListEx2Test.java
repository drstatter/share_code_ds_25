package lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListEx2Test {

    @Test
    public void addFirstPrependsElements() {
        LinkedListEx2<Integer> list = new LinkedListEx2<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        assertEquals("30 20 10 ", list.toString());
    }

    @Test
    public void emptyListToStringIsEmpty() {
        LinkedListEx2<Integer> list = new LinkedListEx2<>();
        assertEquals("", list.toString());
    }
}
