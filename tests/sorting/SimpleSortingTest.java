package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSortingTest {

    private final Integer[] data = {5, 2, 9, 1, 5, 6};

    @Test
    public void bubbleSortSortsAscending() {
        SimpleSorting sorter = new SimpleSorting();
        Comparable[] result = sorter.bubbleSort(data.clone());
        assertArrayEquals(new Integer[]{1, 2, 5, 5, 6, 9}, result);
    }

    @Test
    public void selectionSortSortsAscending() {
        SimpleSorting sorter = new SimpleSorting();
        Comparable[] result = sorter.selectionSort(data.clone());
        assertArrayEquals(new Integer[]{1, 2, 5, 5, 6, 9}, result);
    }

    @Test
    public void insertionSortSortsAscending() {
        SimpleSorting sorter = new SimpleSorting();
        Integer[] result = sorter.insertionSort(data.clone());
        assertArrayEquals(new Integer[]{1, 2, 5, 5, 6, 9}, result);
    }
}
