package lists;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergesortTest {

    @Test
    public void sortsUnsortedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(4);
        list.addFirst(2);
        list.addFirst(5);
        list.addFirst(1);
        list.addFirst(3);

        Mergesort<Integer> sorter = new Mergesort<>();
        sorter.mergeSort(list);

        assertEquals("1 2 3 4 5 ", list.toString());
    }

    @Test
    public void singleElementListStaysUnchanged() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(7);

        Mergesort<Integer> sorter = new Mergesort<>();
        sorter.mergeSort(list);

        assertEquals("7 ", list.toString());
    }

    @Test
    public void emptyListStaysEmpty() {
        LinkedList<Integer> list = new LinkedList<>();

        Mergesort<Integer> sorter = new Mergesort<>();
        sorter.mergeSort(list);

        assertEquals("", list.toString());
    }
}
