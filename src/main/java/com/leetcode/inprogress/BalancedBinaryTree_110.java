package com.leetcode.inprogress;

import com.leetcode.utils.TreeNode;

public class BalancedBinaryTree_110 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return false;
    }

    public int followDirection(TreeNode root, boolean right, int currentDepth) {
        if (root == null) {
            return currentDepth;
        } else {
            currentDepth++;
        }
        if (right) {
            currentDepth = followDirection(root, right, currentDepth);
        } else {
            currentDepth = followDirection(root, right, currentDepth);
        }
        return currentDepth;
    }
}
