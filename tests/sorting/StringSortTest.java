package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringSortTest {

    @Test
    public void sortsIgnoringCaseButPreservingOriginalCase() {
        StringSort sorter = new StringSort();
        assertEquals("AbcD", sorter.sortString("bAcD"));
    }

    @Test
    public void sortedResultHasSameLengthAsInput() {
        StringSort sorter = new StringSort();
        String result = sorter.sortString("dAcD");
        assertEquals(4, result.length());
    }

    @Test
    public void emptyStringStaysEmpty() {
        StringSort sorter = new StringSort();
        assertEquals("", sorter.sortString(""));
    }
}
