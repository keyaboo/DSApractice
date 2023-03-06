package com.leetcode.inprogress;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class CountGoodMeals_1711 {
    public static void main(String[] args) {

    }

    public static int countPairs(int[] deliciousness) {
        int len = deliciousness.length;
        Integer max2n;
        Integer biggestcombo = deliciousness[0]; // clever initialization to handle the 1 <= deliciousness.length case
        if (len > 2) {
            biggestcombo = deliciousness[len-1] + deliciousness[len-2];
        }
        int pow = 1;
        int counter = 1;
        while (biggestcombo - Math.pow(2,pow) > 0 && (Math.pow(2,pow) < (Math.pow(10,9) + 7))) {
            pow = 2 * pow;
            counter++;
        }
        // and then from here seems like a straightforward AddTwoNumbers
        int combos = 0;
        Hashtable<Integer, List<Integer>> ht = new Hashtable<>();
        for (int i = 0; i < deliciousness.length; i++) {
            if (ht.contains(deliciousness[i])) {
                List<Integer> }
            int selected = deliciousness[i];
            for (int k = 0; k < counter; k++) {
                int target = ((int) (Math.pow(2,k)) - selected);

                 // I think this is going to run into a problem
            }
        }

        return combos;
    }
}
