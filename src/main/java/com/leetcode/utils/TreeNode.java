package com.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public Integer val;
    public TreeNode parent, left, right;

    public TreeNode() {}
    public TreeNode(Integer val) { this.val = val; }

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
        if (val == null) {
            return l;
        }
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

    // anything with the 'inOrder' label comes from https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
    public static TreeNode insertLevelOrder(Integer[] arr, Integer i) {
        TreeNode root = null;
        if (i < arr.length) {
            root = new TreeNode(arr[i]);
            // insert left child
            root.left = insertLevelOrder(arr, 2*i + 1);
            // insert right child
            root.right = insertLevelOrder(arr, 2*i + 2);
        }
        return root;
    }

    public static TreeNode createTreeNodeLevelOrder(Integer... values) {
        Integer[] arr = new Integer[values.length];
            for (Integer i = 0; i < values.length; i++) {
                arr[i] = values[i];
            }
            return insertLevelOrder(arr,0);
        }

    public static void inOrderPrint(TreeNode treeNode) {
        if (treeNode != null) {
            inOrderPrint(treeNode.left);
            System.out.print(treeNode.val + "-> ");
            inOrderPrint(treeNode.right);
        }
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
            if (!vals.contains(l.val)) {
                vals.add(l.val);
            }
            if (l.left != null && l.right != null) {
                if (!vals.contains(l.left.val)) {
                    vals.add(l.left.val);
                }
                if (!vals.contains(l.right.val)) {
                    vals.add(l.right.val);
                }
            }
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
