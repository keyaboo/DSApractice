package com.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public Integer val;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right, TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public static TreeNode insertTree(TreeNode l, Integer val) {
        if (l == null) {
            l = new TreeNode(val);
            return l;
        }
        if (val < l.val) {
            l.left = insertTree(l.left, val);
        } else {
            l.right =insertTree(l.right, val);
        }
        return l;
    }

    public static TreeNode createTreeNode(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        TreeNode prev = root;
        for (int i = 1; i < values.length; i++) {
            prev = insertTree(prev, values[i]);
        }
        return root;
    }

    public static void traverseTree(TreeNode l){
        if (l != null) {
            traverseTree(l.left);

            traverseTree(l.right);
        }
    }

    public void traverseInPreOrder(TreeNode l, List<Integer> vals) {
        if (l != null) {
            vals.add(l.val);
            traverseInPreOrder(l.left, vals);
            traverseInPreOrder(l.right, vals);
        }
    }

    @Override
    public String toString() {
        List<Integer> values = new ArrayList<Integer>();
        traverseInPreOrder(this, values);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i) + " ->");
        }
        return sb.toString();
    }



}
