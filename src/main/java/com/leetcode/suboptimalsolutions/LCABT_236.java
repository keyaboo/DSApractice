package com.leetcode.suboptimalsolutions;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * for this problem you can't do a swap of values to know where to look. have to actually do a search for regular
 * binary tree have to return the node of the deepest recursion call where hasAncestor(p) && hasAncestor(q)
 *
 * this is a bad approach because the deeper element in the list doesn't necessarily correspond to the
 * deeper node in the tree. My hacky solution is to cycle through the parents, look for similarities,
 * call the union node "candidate", and then calling hasAncestor again searching for candidate within parent.
 * if it's a hit, reassign parent to candidate.
 *
 * I imagine this won't get an impressive time score.
 *
 * ^^ ooooooh I'm right it was dogshit but I got it right at least.
 */
public class LCABT_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pParents = new ArrayList<>();
        List<TreeNode> qParents = new ArrayList<>();
        hasAncestor(root, p, pParents);
        hasAncestor(root, q, qParents);
        TreeNode parent = root;
        for (int i = 0; i < pParents.size(); i++) {
            if (qParents.contains(pParents.get(i))) {
                TreeNode candidate = pParents.get(i);
                if (hasAncestor(parent, candidate, new ArrayList<TreeNode>())) {
                    parent = candidate;
                }
                }
            }
        return parent;
    }


    private boolean hasAncestor(TreeNode node, TreeNode searched, List<TreeNode> parents) {
        if (node == null) {
            return false;
        }
        if (node == searched) {
            parents.add(node);
            return true;
        } else if (hasAncestor(node.left, searched, parents)) {
            parents.add(node);
            return true;
        } else if (hasAncestor(node.right, searched, parents)) {
            parents.add(node);
            return true;
        }
        return false;
    }
}
