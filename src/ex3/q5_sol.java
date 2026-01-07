package ex3;

import java.util.*;

/**
 * Question 5: K-th Smallest in BST with O(1) extra space.
 *
 * Solution:
 *  Use Morris inorder traversal to visit nodes in sorted order without a stack/recursion.
 *  Count nodes as you go; when count == k, return the node's value.
 *  All temporary pointer changes are restored (tree integrity preserved).
 *
 * Complexity:
 *  - Time: O(n) worst-case (each edge visited at most twice)
 *  - Space: O(1) extra (no stack, no recursion)
 */
public class q5_sol {

    /* ========================= Solution Method ========================= */

    /**
     * Return the k-th smallest value (1-indexed) in the BST using O(1) extra space.
     * Throws IllegalArgumentException if k is out of range.
     */
    public static int kthSmallestO1(TreeNode root, int k) {
      if (root == null || k <= 0) {
            throw new IllegalArgumentException("Invalid input: empty tree or non-positive k");
        }

   int cnt = 0;  // This will count the nodes as we traverse
    TreeNode curr = root;
    int result = -1; 

    while (curr != null) {
        // If left child is null, process the current node
        if (curr.left == null) {
            cnt++;  // We have visited a node

            // If this is the k-th smallest, return the current node's value
            if (cnt == k) {
                result= curr.val;
            }

            // Move to the right node
            curr = curr.right;
        } else {
            // Find the inorder predecessor (rightmost node of left subtree)
            TreeNode pre = curr.left;

            // Find the rightmost node in the left subtree, or the predecessor's right child is curr
            while (pre.right != null && pre.right != curr) {
                pre = pre.right;
            }

            // If the right child of the predecessor is null, establish a temporary link to curr
            if (pre.right == null) {
                pre.right = curr;  // Create a temporary link to current node
                curr = curr.left;  // Move to the left child
            } else {
                // If the right child of the predecessor points to curr, restore the tree
                pre.right = null;  // Break the temporary link

                cnt++;  // We have visited the current node

                // If this is the k-th smallest, return the current node's value
                if (cnt == k) {
                    result = curr.val;
                }

                // Move to the right node
                curr = curr.right;
            }
        }
    }
    return result;

    }

    /* ========================= Provided: Tree Node & Utilities ========================= */

    /** Basic BST node. */
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { this.val = v; }
    }

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

    /** (Optional) Inorder traversal for verification. */
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

    /* ========================= Demo ========================= */

    public static void main(String[] args) {
        // Build a sample BST
        int[] values = {7, 4, 9, 2, 5, 10, 1, 3, 6, 8};
        TreeNode root = buildBST(values);

        // Show inorder (sorted) to verify what the k-th values should be
        List<Integer> in = inorder(root);
        System.out.println("Inorder (sorted): " + in);

        int[] ks = {1, 3, 5, 7, 9};
        for (int k : ks) {
            int ans = kthSmallestO1(root, k);
            System.out.printf("k=%d -> %d (expected %d)%n", k, ans, in.get(k - 1));
        }
    }
}
