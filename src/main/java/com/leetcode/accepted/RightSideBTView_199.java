package com.leetcode.accepted;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    the question to ask is whether node.right child being null but a root.left does exist, presumably you take
    the left path otherwise this problem is absurdly trivial.

    misunderstanding with problem: didn't want to ever go down root's left path but that's not quite right

    don't conditionally traverse left if going down right didn't add anything, that's band-aid thinking but I'm
    inclined to think maybe faster?

    recursion blows for memory, BFS approaches
 */
public class RightSideBTView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverseRight(root, res, 0);
        return res;
    }

    public void traverseRight(TreeNode root, List<Integer> vals, int level) {
        if (root == null) {
            return;
        }
        if (vals.size() == level) {
            vals.add(root.val);
        }
        traverseRight(root.right, vals, level + 1);
        traverseRight(root.left, vals, level + 1);

    }

    /*
    bfs approach I'm stealing, weird ass loop

    The true trick to implementing Breadth-First-Search (BFS) and being able to distinguish between elements from
    a single level from elements currently being added for the next level, is to keep track of the size of the
    queue before starting the traversal of the current level.

    The basic idea is that BFS will find all the child node in the same level, and we just need to reutrn the last node value for each level.
     */

    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (i == level - 1) res.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
        }
        return res;
    }
}
