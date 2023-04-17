package com.leetcode.inprogress;

import com.leetcode.utils.TreeNode;

/**
 * path may or may not pass through the root so imagining some sort of fork with very wide divergence
 * for the same child root node, even moreso than the diff between a long child and root complement.
 * Just thinking the check for this could be finding the maxdepth of both left and right, tenatively store
 * the sum as a greedy variable but if the longer is more than 2 times that of the shorter, do the same
 * max depth calculation on the longer child.
 *
 * this would be so much more convenient if I could manipulate the tree to ensure left is always longer or whatever.
 *
 * I didn't account for the possibility that rlength could be zero
 */
public class DiameterOfBT_543 {
    public static void main(String[] args) {

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        if (lDepth < rDepth) {
            root = swap(root);
            int temp = lDepth;
            lDepth = rDepth;
            rDepth = temp;
        }
        if (lDepth > 2 * rDepth) {
            while (lDepth > 2 * rDepth) {
                root = root.left;
                lDepth = maxDepth(root.left);
                rDepth = maxDepth(root.right);
                if (lDepth < rDepth) {
                    root = swap(root);
                    int temp = lDepth;
                    lDepth = rDepth;
                    rDepth = temp;
                }
            }
            return lDepth + rDepth;
        } else {
            return lDepth + rDepth;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = 1 + maxDepth(root.left);
        int rDepth = 1 + maxDepth(root.right);
        return Math.max(lDepth, rDepth);
    }

    public static TreeNode swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
