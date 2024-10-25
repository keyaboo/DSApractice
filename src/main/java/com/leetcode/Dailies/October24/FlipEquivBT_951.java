package com.leetcode.Dailies.October24;

import com.leetcode.utils.TreeNode;

import java.util.Stack;

/*
LC daily 10/24/2024
    keep tracing node1 dfs style. Since checks on val are annoying just write a helper function.
 */
public class FlipEquivBT_951 {

    // dfs iterative
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> root1Nodes = new Stack<>();
        Stack<TreeNode> root2Nodes = new Stack<>();
        root1Nodes.push(root1);
        root2Nodes.push(root2);
        while (!root1Nodes.isEmpty() && !root2Nodes.isEmpty()) {
            TreeNode node1 = root1Nodes.pop();
            TreeNode node2 = root2Nodes.pop();

            if (node1 == null && node2 == null) {
                continue;
            } else if ((node1 != null && node2 == null) || (node2 != null && node1 == null)) {
                return false;
            } else if (node1 != null && node2 != null) {
                if (node1.val != node2.val) {
                    return false;
                }
            }
            if (validCompareVals(node1.left, node2.left)) {
                root1Nodes.push(node1.left);
                root1Nodes.push(node1.right);
            } else { // condition doesn't really have to be specified because everything above will eventually catch
                root1Nodes.push(node1.right);
                root1Nodes.push(node1.left);
            }
            root2Nodes.push(node2.left);
            root2Nodes.push(node2.right);
        }

        return root2Nodes.isEmpty() && root1Nodes.isEmpty();
    }

    boolean validCompareVals(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return true;
            } else { return false; }
        } else {
            return false;
        }
    }

    // since all the beginning conditions check for us whether or not the child vals are equal, no need for a helper
    // function just call the method recursively. The swap or noswap is easier to read but witout looking at the
    // solution I'd probably write a messy single statement and get something wrong. Straightforward though.
    boolean flipEquivRecursive(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        // recursively call the function
        boolean noswap = (flipEquivRecursive(node1.left, node2.left) && flipEquivRecursive(node1.right, node2.right));

        boolean swap = (flipEquivRecursive(node1.left, node2.right) && flipEquivRecursive(node1.right, node2.left));

        return swap || noswap;
    }



}
