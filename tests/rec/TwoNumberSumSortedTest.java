package rec;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoNumberSumSortedTest {

    private final int[] data = {1, 2, 3, 4, 6, 8, 9, 11, 15, 20};
    private final TwoNumberSumSorted solver = new TwoNumberSumSorted();

    @Test
    public void findsExistingPairRecursively() {
        assertTrue(solver.subsetSumSorted(data, 14));
    }

    @Test
    public void doesNotFindMissingPairRecursively() {
        assertFalse(solver.subsetSumSorted(data, 30));
    }

    @Test
    public void findsExistingPairIteratively() {
        assertTrue(solver.SubsetSumSortedIter(data, 14));
    }

    @Test
    public void doesNotFindMissingPairIteratively() {
        assertFalse(solver.SubsetSumSortedIter(data, 30));
    }

    @Test
    public void findSumBruteForceFindsPair() {
        assertTrue(solver.findSum(data, 14));
        assertFalse(solver.findSum(data, 100));
    }
}
