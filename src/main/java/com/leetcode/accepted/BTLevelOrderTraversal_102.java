package com.leetcode.accepted;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * this is really similar to zigzag which I attempted when I was dumb and didn't know about maxdepth.
 * I think for this I might actually want to delete the maxDepth nodes from the tree after recording vals
 * into the corresponding list?
 *
 * no can't do that, would require waaay too many calls to maxdepth and it wouldn't preserve the left -> right
 * order of the lists being returned. need a recursive function that knows which level it's on to begin with.
 *
 * or instead of that, maybe some sort of queue/set?
 *
 * ok instead, never call maxdepth, have a hashmap of <int level, arrayList<int> nodevals>, and instead of
 * creating a corresponding hashset of traversedNodes for checking whether the value arraylist already contains a node,
 * the fact that it's a binary tree we can know this already by going as far to the left as we can at the beginning,
 * traversing a given level's left first, then the rights and going down or up depending on whether you can go deeper.
 *
 * difficult to tell whether to add root to the map first or to reach it via traversal, I'll go with the second and pray
 *
 * lol I actually got burned using currentlevel++ instead of currentLevel + 1 in the L/R functioncalls
 *
 * lesson, stop feeling compelled to write else ffs.
 *
 * better answers mock the level order pattern that I saw in ADM, which is
 * nullcheck
 * processItem(node)
 * traverse(node.left)
 * traverse(node.right)
 *
 * instead what I have here is more like post order traversal with weird checks. I was too concerned with the ordering
 * of the level lists that I prioritized reaching as far to the left as quickly as possible.
 */
public class BTLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(); // mark of cain, again, output is empty list ex3: (Input: root = [], Output: [])
        }
        HashMap<Integer, ArrayList<Integer>> valsByLevel = new HashMap<>();
        traverse(1,valsByLevel,root);
        int maxLevel = valsByLevel.keySet().stream().max(Integer::compareTo).get();
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= maxLevel; i++) {
            res.add(valsByLevel.get(i));
        }
        return res;
    }

    public static void traverse(Integer currentLevel, HashMap<Integer, ArrayList<Integer>> valsByLevel, TreeNode node) {
        if (node.left != null)
            traverse(currentLevel + 1, valsByLevel, node.left);

        if (node.right != null)
            traverse(currentLevel + 1, valsByLevel, node.right);

            if (!(valsByLevel.containsKey(currentLevel))) {
                valsByLevel.computeIfAbsent(currentLevel, k -> new ArrayList<>());
            }
            valsByLevel.get(currentLevel).add(node.val);
    }



    /**
     * nice decoration
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
