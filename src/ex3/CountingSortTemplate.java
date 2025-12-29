package ex3;

import java.util.Arrays;
import java.util.Random;

/**
 * Question 2: Counting Sort in the range [-n, n]
 *
 * Solution:
 *  Counting sort using an offset-based frequency array of size (2n + 1),
 *  where n = arr.length. Values v ∈ [-n, n] are mapped to indices v + n ∈ [0, 2n].
 *
 * This program:
 *  - Picks a random array length in [5, 50]
 *  - Initializes each element uniformly at random in [-n, n]
 *  - Prints the original array and the sorted array
 */
public class CountingSortTemplate {

    public static void main(String[] args) {
        int[] arr = createRandomArray();
        System.out.println("n = " + arr.length);
        System.out.println("Original: " + Arrays.toString(arr));

        countingSortRangeNegToPos(arr);

        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    /**
     * Counting sort for values in [-n, n], where n = arr.length.
     * Time: O(n) | Space: O(n)
     */
    public static void countingSortRangeNegToPos(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;

        // Frequency array for the entire domain [-n, n] -> [0, 2n]
        int[] freq = new int[2 * n + 1];

        // Count frequencies with offset
        for (int v : arr) {
            // Optional: bounds check (can be removed if input is guaranteed)
            if (v < -n || v > n) {
                throw new IllegalArgumentException("Value " + v + " out of allowed range [-" + n + ", " + n + "]");
            }
            freq[v + n]++;
        }

        // Rewrite arr in non-decreasing order using frequencies
        int write = 0;
        for (int idx = 0; idx < freq.length; idx++) {
            int count = freq[idx];
            int value = idx - n; // inverse of offset mapping
            while (count-- > 0) {
                arr[write++] = value;
            }
        }
    }

    /* --------------------- Utility: randomization --------------------- */

    // Create random array with random length in [5, 50], values in [-n, n]
    private static int[] createRandomArray() {
        Random rnd = new Random();
        int n = rnd.nextInt(10) + 5; // length ∈ [5, 50]
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // uniform in [-n, n]
            arr[i] = rnd.nextInt(2 * n + 1) - n;
        }
        return arr;
    }
}
