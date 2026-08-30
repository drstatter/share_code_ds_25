package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class flagTest {

    @Test
    public void sortPartitionsZerosOnesAndTwos() {
        flag sorter = new flag();
        int[] data = {2, 0, 1, 2, 1, 0};
        int[] result = sorter.sort(data);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, result);
    }

    @Test
    public void sort2CountsZerosThenFillsOnes() {
        flag sorter = new flag();
        int[] data = {0, 1, 0, 1, 1};
        int[] result = sorter.sort2(data);
        assertArrayEquals(new int[]{0, 0, 1, 1, 1}, result);
    }
}
