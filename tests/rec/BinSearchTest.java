package rec;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinSearchTest {

    private final int[] data = {4, 6, 8, 12, 42, 101, 999};
    private final BinSearch searcher = new BinSearch();

    @Test
    public void findsExistingElementRecursively() {
        assertEquals(3, searcher.binSearch(data, 12));
    }

    @Test
    public void findsExistingElementIteratively() {
        assertEquals(3, searcher.binSearchIter(data, 12));
    }

    @Test
    public void returnsNotFoundForMissingElementRecursively() {
        assertEquals(searcher.NOT_FOUND, searcher.binSearch(data, 13));
    }

    @Test
    public void returnsNotFoundForMissingElementIteratively() {
        assertEquals(searcher.NOT_FOUND, searcher.binSearchIter(data, 13));
    }

    @Test(expected = NullPointerException.class)
    public void nullArrayThrowsBeforeReachingNullCheck() {
        searcher.binSearch(null, 5);
    }
}
