package com.leetcode.badstrategies;

import java.util.*;

/**
 * contains KEY not contains, contains KEYYYYYYYYY when you check hashtables
 */
public class CountGoodMeals_1711 {
    public static void main(String[] args) {
        int[] deliciousness = {149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        System.out.println(countPairs(deliciousness));

    }

    public static int countPairs(int[] deliciousness) {
        Arrays.sort(deliciousness); // didn't say whether it was sorted so of course it's not when I go to submit
        int len = deliciousness.length;
        Integer biggestcombo = deliciousness[0]; // clever initialization to handle the 1 <= deliciousness.length case
        if (len > 2) {
            biggestcombo = deliciousness[len - 1] + deliciousness[len - 2];
        }
        System.out.println("biggestcombo=" + biggestcombo);
        int pow = 1;
        // huge fuckup here courtesy of this problem's example adding up to 16 exactly, needs to be gt or eq to
        while (biggestcombo - Math.pow(2, pow) >= 0 && (Math.pow(2, pow) < (Math.pow(10, 9) + 7))) {
            pow++;
        }
        // and then from here seems like a straightforward AddTwoNumbers
        int combos = 0;
        Hashtable<Integer, List<Integer>> ht = new Hashtable<>();
        for (int i = 0; i < deliciousness.length; i++) {
            if (ht.containsKey(deliciousness[i])) {
                System.out.println(deliciousness[i]);
                List<Integer> onIndices = ht.get(deliciousness[i]);
                System.out.println(onIndices.get(0));
                combos = combos + onIndices.size();
                }
                int selected = deliciousness[i];
                System.out.println(selected);
                for (int k = 1; k < pow + 1; k++) {
                    int target = ((int) (Math.pow(2, k)) - selected);
                    if (ht.containsKey(target)) {
                        List<Integer> existingList = ht.get(target);
                        existingList.add(i);
                        ht.put(target, existingList);
                    } else if (target >= 0) {
                        System.out.println("target=" + target);
                        List<Integer> newList = new ArrayList<>();
                        newList.add(i);
                        ht.put(target, newList);
                    }
                    // I think this is going to run into a problem
                }
            }
        return combos;
    }
}

