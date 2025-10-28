package sorting;

public class SortMatrix {
    //this function sort the matrix main diagonal in ascending order and in place without using any extra space
    // using insertion sort algorithm
    public void sortMatrixDiagonal(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            int key = matrix[i][i];
            int j = i - 1;
            while (j >= 0 && matrix[j][j] > key) {
                matrix[j + 1][j + 1] = matrix[j][j];
                j = j - 1;
            }
            matrix[j + 1][j + 1] = key;
        }
    }
    private void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SortMatrix sorter = new SortMatrix();
        int[][] matrix = {
                {5, 2, 3},
                {4, 1, 6},
                {7, 8, 0}
        };
        sorter.sortMatrixDiagonal(matrix);
        sorter.printMatrix(matrix);
    }
}
