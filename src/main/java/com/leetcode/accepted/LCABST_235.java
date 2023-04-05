package com.leetcode.accepted;

import com.leetcode.utils.TreeNode;

/**
 * the important constraint I was wondering about is that p and q will exist in the BST
 */
public class LCABST_235 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode(6,2,8,0,4,7,9,null,null,3,5);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val < p.val) { // little swapperino
            TreeNode temp = new TreeNode(p.val);
            p = q;
            q = temp;
        }
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        }
        else if (root.val >= p.val && root.val >= q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val <= p.val && root.val <= q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
