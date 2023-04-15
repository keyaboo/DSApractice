package com.leetcode.accepted;

import com.leetcode.utils.TreeNode;

/**
 * one of those figure it out in 1 minute without looking
 */
public class MaxDepth_104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l_depth = 1 + maxDepth(root.left);
        int r_depth = 1 + maxDepth(root.right);
        return Math.max(l_depth, r_depth);
    }
}
