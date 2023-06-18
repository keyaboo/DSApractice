package com.leetcode.accepted;

import com.leetcode.utils.TreeNode;

/**
 * this approach embeds the boolean return I had in my bad approach into null/node TreeNode returns.
 * it propogates the lca node up the tree
 * I had trouble at first identifying where null was actually being returned
 * there's a recursive nullcheck if at the beginning but in a different form compared to the standard template.
 * normally the nullcheck would not return a bool or in a void method "return" nothing, but in this case we're using the
 * empty left/right children to call a given parent node "null" to do conditional logic on. This would normally
 * make the entire tree null, except valid nodes equal to p and q are also propogated upwards. The valid descendent
 * propogated up depends on which of the split children is equal to null, so if only one of p or q exits at a given
 * node, return it. if neither do, null moves up and if both of them exist, you're left with the LCA.
 *
 * also once it reaches p or q, it stops searching for successors which has an interesting effect in the case
 * of p being a descendant of q or vice versa. q would move all the way up to the original root's lca function call,
 * and would consequently be returned because the corresponding L/R would have to be null.
 *
 * in other words, it can't "know" how much further below p is if it's a descendant of q, the algorithm will return
 * q which happens to be the right answer.
 */
public class LCABT_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
