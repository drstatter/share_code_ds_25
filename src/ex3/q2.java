
import java.util.Arrays;
import java.util.Random;

/**
 * Question 2: Counting Sort in the range [-n, n]
 *
 * Goal:
 *  Implement counting sort for an integer array whose values lie in the range [-n, n],
 *  where n = arr.length (the array length).
 *
 * Requirements:
 *  - Time complexity should be O(n).
 *  - Handle negative and positive values in [-n, n] via offset mapping.
 *  - Do not use comparison-based sorting (i.e., no Arrays.sort for the main logic).
 *
 * This template:
 *  - Picks a random array length in [5, 50].
 *  - Initializes each element uniformly at random in [-n, n].
 *  - Prints the original array and the result after calling countingSortRangeNegToPos.
 */
public class CountingSortTemplate {

    public static void main(String[] args) {
        int[] arr = createRandomArray();
        System.out.println("n = " + arr.length);
        System.out.println("Original: " + Arrays.toString(arr));

        // ===== Student method (TODO inside) =====
        countingSortRangeNegToPos(arr);

        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    /**
     * ======= STUDENT TASK =======
     * Implement counting sort assuming all values are in [-n, n], where n = arr.length.
     *
     * Guidelines (non-solution):
     *  - Build a frequency array sized for the whole range (2n + 1).
     *  - Map a value v in [-n, n] to an index in [0, 2n] via offset: index = v + n.
     *  - Reconstruct arr in non-decreasing order using the frequencies.
     *  - Keep overall time O(n) and avoid unnecessary loops.
     */
    public static void countingSortRangeNegToPos(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
    }

    /* --------------------- Utility: randomization --------------------- */

    // Create random array with random length in [5, 50], values in [-n, n]
    private static int[] createRandomArray() {
        Random rnd = new Random();
        int n = rnd.nextInt(10) + 5; 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // uniform in [-n, n]
            arr[i] = rnd.nextInt(2 * n + 1) - n;
        }
        return arr;
    }
}
