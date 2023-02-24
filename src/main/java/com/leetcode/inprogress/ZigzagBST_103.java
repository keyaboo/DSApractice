package com.leetcode.inprogress;
import com.leetcode.utils.TreeNode;
import java.util.ArrayList;

import java.util.List;

public class ZigzagBST_103 {
    public static void main(String[] args){
        TreeNode treeNode = TreeNode.createTreeNodeLevelOrder(3,9,20,null,null,15,7);
//        TreeNode treeNode = TreeNode.createTreeNodeLevelOrder(1, 2, 3, 4, 5, 6, 6, 6, 6);
        zigzagLevelOrder(treeNode);
//        TreeNode.inOrderPrint(treeNode);
        System.out.println("findbottom=" +findBottom(treeNode,0));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> returnedList = new ArrayList<List<Integer>>();
        for (int i = 0; i < findBottom(root,0); i++) {
            System.out.println("i=" + i);
            List<Integer> layerList = new ArrayList<Integer>();
            findLevelVals(root,0, i, (ArrayList<Integer>) layerList);
            for (int k = 0; k < layerList.size(); k++) {
                System.out.print(layerList.get(k));
            }
            System.out.println("");
            returnedList.add(layerList);
        }
        return returnedList;
    }

    public static Integer findLevelVals(TreeNode l, int currentLevel, int finalLevel, ArrayList<Integer> levelVals) {
        if (l != null) {
            Integer level2;
            level2 = currentLevel + 1 + findBottom(l.left, currentLevel);
            if (level2 > currentLevel) {currentLevel++;
                if (currentLevel == finalLevel) {
                levelVals.add(l.val);}
            }
            level2 = currentLevel + 1 + findBottom(l.right, currentLevel);
            if (level2 > currentLevel) {currentLevel++;
                if (currentLevel == finalLevel) {
                    levelVals.add(l.val);}
            }
        }
        return currentLevel;
    }

    public static Integer findBottom(TreeNode l, int level) {
        if (l != null) {
            Integer level2;
            level2 = level + 1 + findBottom(l.left, level);
            if (level2 > level) {level++;}
            level2 = level + 1 + findBottom(l.right, level);
            if (level2 > level) {level++;}
        }
        return level;
    }

}
