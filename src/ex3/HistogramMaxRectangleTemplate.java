package ex3;

import java.util.Arrays;

/**
 * Exercise: Largest Rectangular Area in a Histogram
 *
 * Problem:
 *  Given an integer array heights[] where heights[i] is the height of the bar at index i,
 *  compute the area of the largest rectangle that can be formed within the histogram.
 *  Rectangles must be contiguous (consecutive bars).
 *
 * Constraints (recommended):
 *  - 1 <= heights.length <= 200_000
 *  - 0 <= heights[i] <= 1_000_000_000
 *
 * Examples:
 *  - [2, 1, 5, 6, 2, 3] -> 10
 *  - [2, 4]             -> 4
 *  - [0, 0, 0]          -> 0
 *
 * Notes:
 *  - You may use the provided IntStack (stack of ints) below.
 */
public class HistogramMaxRectangleTemplate {

    /**
     * ====== STUDENT TASK ======
     * Implement this method.
     *
     * Input:
     *  - heights: array of non-negative integers representing bar heights.
     *
     * Output:
     *  - Return the max rectangular area (as an int or long; int is fine if you assume no overflow).
     *
     * Tips (non-solution):
     *  - Consider how you decide when a bar "stops" extending left/right.
     *  - Think about indices, not just heights.
     *  - Consider boundary/sentinel logic so that all candidate rectangles get evaluated.
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        IntStack st = new IntStack(heights.length + 1); // holds indices with increasing heights
        long maxArea = 0; // use long internally to avoid overflow during multiplication

        for (int i = 0; i <= heights.length; i++) {
            int curr = (i == heights.length) ? 0 : heights[i]; // sentinel height at the end
            // While current height breaks the increasing sequence, finalize rectangles
            while (!st.isEmpty() && curr < heights[st.peek()]) {
                int h = heights[st.pop()];
                int leftIndex = st.isEmpty() ? -1 : st.peek(); // previous smaller to the left
                int width = i - leftIndex - 1;                 // span where h is the min
                long area = (long) h * (long) width;
                if (area > maxArea) maxArea = area;
            }
            st.push(i);
        }

        // maxArea fits in int for the given example constraints, but cast carefully
        return (int) Math.min(maxArea, Integer.MAX_VALUE);
    }

    /* ---------------------- Provided Utilities (Students can use) ---------------------- */

    /**
     * A lightweight, array-based stack for primitive ints.
     * Operations: push, pop, peek, isEmpty, size, clear.
     */
    static class IntStack {
        private int[] a;
        private int top = -1;

        public IntStack(int capacity) {
            if (capacity < 1) capacity = 1;
            a = new int[capacity];
        }

        public void push(int x) {
            if (top + 1 == a.length) grow();
            a[++top] = x;
        }

        public int pop() {
            if (top < 0) throw new IllegalStateException("pop from empty stack");
            return a[top--];
        }

        public int peek() {
            if (top < 0) throw new IllegalStateException("peek from empty stack");
            return a[top];
        }

        public boolean isEmpty() {
            return top < 0;
        }

        public int size() {
            return top + 1;
        }

        public void clear() {
            top = -1;
        }

        private void grow() {
            a = Arrays.copyOf(a, Math.max(2, a.length * 2));
        }
    }

    /* ---------------------- Test Harness ---------------------- */

    public static void main(String[] args) {
        // Basic tests
        runTest(new int[]{2, 1, 5, 6, 2, 3}, 10);
        runTest(new int[]{2, 4}, 4);
        runTest(new int[]{0, 0, 0}, 0);
        runTest(new int[]{6, 2, 5, 4, 5, 1, 6}, 12);

        // Edge cases
        runTest(new int[]{}, 0);
        runTest(new int[]{5}, 5);
        runTest(new int[]{1, 1, 1, 1}, 4);
        runTest(new int[]{5, 4, 3, 2, 1}, 9);   // best is 3*3 using [5,4,3] or 4*2, 5*1
        runTest(new int[]{1, 2, 3, 4, 5}, 9);   // best is 3*3 using [3,4,5] or 4*2, 5*1
        runTest(new int[]{1000000000, 1000000000}, 2000000000); // check potential overflow thinking

        // Feel free to add more randomized tests or large arrays for stress testing.
    }

    private static void runTest(int[] heights, int expected) {
        int actual = largestRectangleArea(heights);
        System.out.printf("heights = %s -> got: %d | expected: %d %s%n",
                Arrays.toString(heights), actual, expected, (actual == expected ? "✓" : "✗"));
    }
}
