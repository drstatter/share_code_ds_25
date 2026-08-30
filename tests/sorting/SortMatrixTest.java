package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortMatrixTest {

    @Test
    public void sortsMainDiagonalAscending() {
        SortMatrix sorter = new SortMatrix();
        int[][] matrix = {
                {5, 2, 3},
                {4, 1, 6},
                {7, 8, 0}
        };
        sorter.sortMatrixDiagonal(matrix);
        assertEquals(0, matrix[0][0]);
        assertEquals(1, matrix[1][1]);
        assertEquals(5, matrix[2][2]);
    }
}
