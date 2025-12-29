package ex3;

import java.util.*;

/**
 * Question 5: K-th Smallest in BST with O(1) extra space.
 *
 * Goal:
 *  Implement kthSmallestO1(TreeNode root, int k) that returns the k-th smallest value (1-indexed)
 *  in a Binary Search Tree, using O(1) extra space (no recursion, no explicit stack).
 *
 * Constraints (recommended):
 *  - 1 <= k <= number of nodes in the BST
 *  - BST property: left < root < right (strictly increasing values)
 *
 * Notes:
 *  - Do NOT use recursion.
 *  - Do NOT use a stack or any additional data structure that grows with n.
 *  - You may modify the tree temporarily during traversal but must restore it.
 *  - Aim for O(n) time in worst case, O(1) extra space.
 */
public class KthSmallestO1Template {

    /* ========================= Student Task ========================= */

    /**
     * ======= STUDENT TASK (TODO) =======
     * Return the k-th smallest value in the BST using O(1) extra space.
     *
     * Input:
     *  - root: the BST root
     *  - k:    1-indexed position in sorted order (inorder)
     *
     * Output:
     *  - the k-th smallest node's value
     *
     * Guidelines (non-solution hints):
     *  - Traverse the tree in-order without a stack (think about temporary threading of nodes).
     *  - Count nodes as you visit them in sorted order; when the counter == k, return the value.
     *  - Ensure the tree is restored to its original shape before returning.
     */
    public static int kthSmallestO1(TreeNode root, int k) {
        throw new UnsupportedOperationException("Implement kthSmallestO1");
    }

    /* ========================= Provided: Tree Node ========================= */

    /** Basic BST node. */
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { this.val = v; }
    }

    /* ========================= Provided: Utilities ========================= */

    /** Insert value into BST (iterative). Duplicates go to the right for consistency. */
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left == null) { cur.left = new TreeNode(val); break; }
                cur = cur.left;
            } else {
                if (cur.right == null) { cur.right = new TreeNode(val); break; }
                cur = cur.right;
            }
        }
        return root;
    }

    /** Build BST from array of values. */
    public static TreeNode buildBST(int[] values) {
        TreeNode root = null;
        for (int v : values) root = insert(root, v);
        return root;
    }

    /** Inorder traversal (recursive) only for printing/verification (not part of the O(1) task). */
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderRec(root, res);
        return res;
    }

    private static void inorderRec(TreeNode n, List<Integer> res) {
        if (n == null) return;
        inorderRec(n.left, res);
        res.add(n.val);
        inorderRec(n.right, res);
    }

    /* ========================= Demo (prints only) ========================= */

    public static void main(String[] args) {
        // Example BST:
        // values will produce BST with inorder sorted order.
        int[] values = {7, 4, 9, 2, 5, 10, 1, 3, 6, 8};
        TreeNode root = buildBST(values);

        // Show inorder to confirm sorted sequence (students can compare with kthSmallestO1 outputs)
        List<Integer> in = inorder(root);
        System.out.println("Inorder (sorted): " + in);

        // Example k values to try after students implement kthSmallestO1:
        int[] ks = {1, 3, 5, 7, 10};
        System.out.println("Try k values (expected are inorder[k-1]): " + Arrays.toString(ks));
        // Uncomment after implementation:
        // for (int k : ks) {
        //     int ans = kthSmallestO1(root, k);
        //     System.out.printf("k=%d -> %d (expected %d)%n", k, ans, in.get(k - 1));
        // }
    }
}