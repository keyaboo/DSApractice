package com.leetcode.accepted;

import java.util.HashMap;
import java.util.HashSet;

/*
atrocious, definitely contributing to that 40% acceptance rate by not considering both possibilities.
 */
public class CheckNandDoubleExist_1346 {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> prev = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (prev.contains(2 * arr[i]) || (arr[i] % 2 == 0 && prev.contains(arr[i] / 2))) {
                return true;
            }
            prev.add(arr[i]);
        }
        return false;
    }
}
