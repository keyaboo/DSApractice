package com.leetcode.annotatedexamples;

import com.leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * recursion isn't the only tool for the job. stacks are great for trees too!
 * iterative traversal of BT algorithm:
 * 1) create an empty stack S
 * 2) initialize current node as root
 * 3) push the current node to s and set current=current->left until current is null
 * 4) if current is null and stack is not empty then
 *      a) pop the top item from stack
 *      b) print the popped item, set current = popped_item->right
 *      c) go to step 3
 *  5) if current is null and stack is empty then we are done.
 *
 *  I don't think this would be terribly obvious: https://www.youtube.com/watch?v=nzmtCFNae9k
 */
public class KthSmallestInBST_230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while ((nodes.size() > 0 || node != null)) { // this didn't make sense as an and, sure enough it's an or, checked.
            while (node != null) {
                nodes.add(node);
                node = node.left;
            }
            node = nodes.pop(); // this should be when we start counting down, it will serve as the lowest value
            // on the bottom left. It's actually going to check whether the lowest value has a right child first
            // which would necessarily be lower than lowest's parent.
            /**
             * oooh here's the trick, when lowest's parent gets popped, a processItem equivalent has already been
             * called because the stack was popped in order to get back to lowest.
             * regardless of what lowest's parent's right contains, the order is going to be lowest, parent,
             * right which is the sorted order after all.
             */
            k--; // this is the equivalent of process item function. print, whatever.
            if (k == 0) {
                break;
            }
            node = node.right;
            }
        return node.val;
    }
}

