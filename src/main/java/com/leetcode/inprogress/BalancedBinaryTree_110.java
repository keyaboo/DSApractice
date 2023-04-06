package com.leetcode.inprogress;

import com.leetcode.utils.TreeNode;

public class BalancedBinaryTree_110 {
    public static void main(String[] args) {
        //
    }

    public boolean isBalanced(TreeNode root) {
        return false;
    }

    public int followDirection(TreeNode root, int currentDepth) {
        if (root == null) {
            return currentDepth;
        } else {
            currentDepth++;
        }
        if (root.right != null) {
            currentDepth = followDirection(root.right, currentDepth);
        } else if (root.left != null) {
            currentDepth = followDirection(root.left, currentDepth);
        }
        return currentDepth;
    }
}
