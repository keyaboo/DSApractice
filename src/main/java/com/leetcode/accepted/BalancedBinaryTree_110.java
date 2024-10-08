package com.leetcode.accepted;

import com.leetcode.utils.TreeNode;

/**
 * what I was missing was the final return for isbalanced being both of the conditionals, and that's why it made it
 * through a lot of the edge cases but not for everything - the double return is quite strange
 *
 * there's also a balance factor which could be implemented in the depth search function. Return -1's as for the
 * depth difference exceeding 1.
 *
 * I tried something really hacky where the depth search included a boolean[] as a call by reference function parameter
 * that got set to true (non-default value) whenever the depth difference threshold was met. You're not supposed to
 * do this. I'm seeing solutions where they use a class variable flag but that seems kinda trash.
 */
public class BalancedBinaryTree_110 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNodeLevelOrder(1,2,2,3,3,null,null,4,4);
        System.out.println(isBalanced(treeNode));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

            if (Math.abs(lDepth - rDepth) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if (leftDepth > rightDepth) {
                return (leftDepth + 1);
            } else {
                return (rightDepth + 1);
            }
        }
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));

    }
}

