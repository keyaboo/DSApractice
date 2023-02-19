package com.leetcode.inprogress;

import com.leetcode.utils.TreeNode;


/**
 * doing the util convenience fns was illustrative for this. Runs pretty quickly but not an impressive memory score.
 * seems the trick for recursive BST methods is to always have the if statement be a null check for the node you're on.
 * this is just a variation of the traverseTree function found in ADM. the second check you can do in the process item
 * function. not surprising this one's considered an easy.
 */
public class InvertBinaryTree226 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNode(4,2,7,1,3,6,9);
        System.out.println(treeNode);
        TreeNode invertedTree = invertTree(treeNode);
        System.out.println(invertedTree);
    }

    public static TreeNode invertTree(TreeNode root){
        TreeNode temp = root;
        if (temp != null) {
            temp = processItem(temp);
            invertTree(temp.left);
            invertTree(temp.right);
        }
        return temp;
    }

    public static TreeNode processItem(TreeNode l) {
        if (l.left != null || l.right != null) {
            TreeNode tempLeft = l.left;
            TreeNode tempRight = l.right;
            l.left = tempRight;
            l.right = tempLeft;
        }
        return l;
    }





}
