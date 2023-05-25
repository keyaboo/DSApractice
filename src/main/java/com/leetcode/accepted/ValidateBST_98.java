package com.leetcode.accepted;

import com.leetcode.utils.TreeNode;

import java.util.Stack;


/**
 * all the recursive solutions seem faster, probably worth investigating.
 */
public class ValidateBST_98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        TreeNode node = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            if (node != null) {
                if (prev != null) {
                    if (node.val <= prev.val) return false;
                }
                prev = node;
            }
            node = node.right;
        }
        return true;
    }
}
