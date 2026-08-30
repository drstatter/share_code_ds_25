package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountingSortTest {

    @Test
    public void sortsUsingCountingSort() {
        CountingSort cs = new CountingSort();
        int[] data = {4, 3, 2, 1, 4, 4, 4, 3, 4};
        int[] result = cs.sort(data, 5);
        assertArrayEquals(new int[]{1, 2, 3, 3, 4, 4, 4, 4, 4}, result);
    }
}
