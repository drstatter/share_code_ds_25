
import java.util.*;

/**
 * Question 4: Build a height-balanced BST from a sorted array.
 *
 * Solution outline:
 *  - Pick the middle element as the root to keep the tree height-balanced.
 *  - Recursively build the left subtree from the left half.
 *  - Recursively build the right subtree from the right half.
 * Time: O(n)   Space: O(h) recursion (h is height, ~log n for balanced tree).
 */
public class BSTFromSortedArrayTemplate {

    /* ========================= Solution ========================= */

    /**
     * Build a height-balanced BST from a sorted (ascending) array.
     * @param nums sorted array (ascending)
     * @return root node of the constructed BST
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(nums, 0, nums.length - 1);
    }

    // Helper: divide & conquer on [l..r]
    private static TreeNode build(int[] a, int l, int r) {
        if (l > r) return null;
        int m = (l + r) >>> 1;      // midpoint
        TreeNode root = new TreeNode(a[m]);
        root.left  = build(a, l, m - 1);
        root.right = build(a, m + 1, r);
        return root;
    }

    /* ========================= Provided: Tree Node ========================= */

    /** Basic BST node. */
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { this.val = v; }
    }

    /* ========================= Provided: Pretty Print ========================= */

    /**
     * Pretty-print the tree structure (ASCII).
     * Prints the tree sideways:
     * - Right subtree up
     * - Root in center
     * - Left subtree down
     *
     * Example:
     *           7
     *       ┌── 6
     *   ┌── 5
     *   │   └── 4
     * 3
     *   │   ┌── 2
     *   └── 1
     */
    public static void printTree(TreeNode root) {
        printTree(root, "", true);
    }

    // Internal helper: builds branches using prefixes
    private static void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) return;

        // Print right subtree first (so tree appears upright)
        printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);

        // Print current node
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);

        // Print left subtree
        printTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
    }

    /**
     * Alternative compact printer (root-centered, children inline).
     * Useful for small trees. Keep both for convenience.
     */
    public static void printTreeInline(TreeNode root) {
        List<String> lines = renderTreeLines(root);
        for (String line : lines) System.out.println(line);
    }

    // Render tree into lines using BFS levels (for inline display)
    private static List<String> renderTreeLines(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            result.add("(empty tree)");
            return result;
        }
        // BFS with null placeholders to keep structure
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        boolean hasNonNull = true;

        while (hasNonNull) {
            hasNonNull = false;
            StringBuilder sb = new StringBuilder();
            List<TreeNode> next = new ArrayList<>();

            for (TreeNode n : level) {
                if (n == null) {
                    sb.append(" . ");
                    next.add(null);
                    next.add(null);
                } else {
                    String s = String.valueOf(n.val);
                    sb.append(" ").append(s).append(" ");
                    next.add(n.left);
                    next.add(n.right);
                    if (n.left != null || n.right != null) hasNonNull = true;
                }
            }

            result.add(sb.toString());
            level = next;
        }
        return result;
    }

    /* ========================= Demo ========================= */

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-10, -3, 0, 5, 9};
        int[] nums3 = {2, 4, 6, 8};

        System.out.println("Array #1: " + Arrays.toString(nums1));
        System.out.println("Array #2: " + Arrays.toString(nums2));
        System.out.println("Array #3: " + Arrays.toString(nums3));
        System.out.println();

        TreeNode t1 = sortedArrayToBST(nums1);
        TreeNode t2 = sortedArrayToBST(nums2);
        TreeNode t3 = sortedArrayToBST(nums3);

        System.out.println("Tree for Array #1:");
        printTree(t1);
        System.out.println("\nTree for Array #2:");
        printTree(t2);
        System.out.println("\nTree for Array #3:");
        printTree(t3);

        System.out.println("\nInline view (Array #1):");
        printTreeInline(t1);
    }
}
