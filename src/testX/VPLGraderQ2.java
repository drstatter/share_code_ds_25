package testX;
import java.util.Arrays;

public class VPLGraderQ2 {
    static int score = 0;

    public static void main(String[] args) {
        try {
            // --- PART 1: FUNCTIONAL TESTS (50 pts) ---
            test(1, new int[]{2, 1, 5, 6, 2, 3}, 10, 5);
            test(2, new int[]{2, 4}, 4, 10);
            test(3, new int[]{2, 4, 9}, 9, 10);
            test(4, new int[]{0, 0, 0}, 0, 10);
            test(5, new int[]{1, 1, 1, 1}, 4, 5);
            test(6, new int[]{5, 4, 3, 2, 1}, 9, 10);

            // --- PART 2: EFFICIENCY COMPARISON (50 pts) ---
            System.out.println("Comment :=>> [INFO] Running Efficiency Benchmark...");

            // Generate massive dataset (100,000 items)
            // We use a "sawtooth" pattern which is bad for naive solutions
            int N = 100000;
            int[] largeInput = new int[N];
            for (int i = 0; i < N; i++) {
                largeInput[i] = i % 1000;
            }
            int[] largeInputCopy = largeInput.clone(); // Give student a fresh copy

            // 1. Measure Reference Solution
            long startRef = System.nanoTime();
            int refResult = ReferenceSolution.largestRectangleArea(largeInput);
            long endRef = System.nanoTime();
            double refTimeMs = (endRef - startRef) / 1_000_000.0;

            // 2. Measure Student Solution
            long startStud = System.nanoTime();
            int studResult = Solution.largestRectangleArea(largeInputCopy);
            long endStud = System.nanoTime();
            double studTimeMs = (endStud - startStud) / 1_000_000.0;

            // Print results for feedback
            System.out.println("Comment :=>> [BENCHMARK] Reference Time: " + String.format("%.2f", refTimeMs) + " ms");
            System.out.println("Comment :=>> [BENCHMARK] Your Time:      " + String.format("%.2f", studTimeMs) + " ms");

            // 3. Logic Check on Large Input
            if (studResult != refResult) {
                System.out.println("Comment :=>> [FAIL] Your solution returned wrong result on large input.");
                System.out.println("Comment :=>> Expected: " + refResult + ", Got: " + studResult);
            } else {
                // 4. Time Comparison
                // We allow the student to be up to 15x slower than reference (generous buffer for Java overhead)
                // But if they are 100x slower (e.g., O(N^2)), they fail.
                double ratio = studTimeMs / Math.max(1.0, refTimeMs); // avoid div by zero

                if (ratio > 3.0 || studTimeMs > 500) {
                    System.out.println("Comment :=>> [PENALTY] Efficiency Check Failed.");
                    System.out.println("Comment :=>> Your code is significantly slower than the reference (" + String.format("%.1f", ratio) + "x slower).");
                    System.out.println("Comment :=>> Likely O(N^2) instead of O(N). Grade halved.");
                    score += 25; // Half points for correctness but slow
                } else {
                    System.out.println("Comment :=>> [PASS] Efficiency Check Passed.");
                    score += 50;
                }
            }

        } catch (Exception e) {
            System.out.println("Comment :=>> Fatal Error: " + e);
        }

        System.out.println("Grade :=>> " + score);
    }

    static void test(int id, int[] in, int exp, int pts) {
        try {
            // Clone input so student modification doesn't break future tests
            int[] copy = in.clone();
            int act = Solution.largestRectangleArea(copy);
            if (act == exp) {
                System.out.println("Comment :=>> [PASS] Test " + id);
                score += pts;
            } else {
                System.out.println("Input array: " + Arrays.toString(in));
                System.out.println("Comment :=>> [FAIL] Test " + id + ". Exp: " + exp + ", Got: " + act);
            }
        } catch (Exception e) {
            System.out.println("Comment :=>> [FAIL] Test " + id + " Exception: " + e);
        }
    }

    // ==========================================
    // INNER CLASS: REFERENCE SOLUTION (TRUSTED)
    // ==========================================
    static class ReferenceSolution {
        public static int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) return 0;

            IntStack st = new IntStack(heights.length + 1);
            long maxArea = 0;

            for (int i = 0; i <= heights.length; i++) {
                int curr = (i == heights.length) ? 0 : heights[i];
                while (!st.isEmpty() && curr < heights[st.peek()]) {
                    int h = heights[st.pop()];
                    int leftIndex = st.isEmpty() ? -1 : st.peek();
                    int width = i - leftIndex - 1;
                    long area = (long) h * (long) width;
                    if (area > maxArea) maxArea = area;
                }
                st.push(i);
            }
            return (int) Math.min(maxArea, Integer.MAX_VALUE);
        }

        // Reference IntStack (Private copy to ensure isolation)
        static class IntStack {
            private int[] a;
            private int top = -1;

            public IntStack(int capacity) {
                a = new int[Math.max(1, capacity)];
            }

            public void push(int x) {
                if (top + 1 == a.length) grow();
                a[++top] = x;
            }

            public int pop() {
                return a[top--];
            }

            public int peek() {
                return a[top];
            }

            public boolean isEmpty() {
                return top < 0;
            }

            private void grow() {
                a = Arrays.copyOf(a, Math.max(2, a.length * 2));
            }
        }
    }
}