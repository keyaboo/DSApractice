package com.leetcode.badstrategies;

import com.leetcode.utils.TreeNode;

/**
 * have traverse return a boolean.
 * process item can simply be the check that L < node < R
 * return validateNode(node.left) && validateNode(node.right)
 *
 * yeah this was garbage
 */
public class ValidateBST_98 {
    public boolean isValidBST(TreeNode root) {
        return validateNode(root);
    }

    public boolean validateNode(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean leftValidation = validateNode(node.left);
        boolean rightValidation = validateNode(node.right);
        if (node.left == null && node.right == null)
            return leftValidation && rightValidation;
        else if (node.left != null && node.right != null)
            return (node.left.val < node.val && node.val < node.right.val);
        else if (leftValidation && node.right != null)
            return (node.val < node.right.val);
        else if (rightValidation && node.left != null)
            return (node.left.val < node.val);
        return false;
    }
}
