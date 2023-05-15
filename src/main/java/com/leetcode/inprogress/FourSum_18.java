package com.leetcode.inprogress;

import java.util.*;

/**
 * do 3 sum minus target and put indices in a set as hashmap val with their sum as key
 *
 * no it's not just 3 sum b/c with that one the distance from 0 decided whether to move left or right.
 * it does incorporate something similar just not in the way I imagined this working out.
 *
 * The arbitrary k sum solution that I saw wasn't easily digestable.
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Set<Integer>>> indexBySum = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right] + target;
            }
        }

        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexBySum.containsKey(nums[i])) {
                ArrayList<Set<Integer>> uniqueIndices = indexBySum.get(nums[i]);
                for (Set<Integer> uniqueIndex:uniqueIndices) {
                    if (!(uniqueIndex.contains(i))) {
                        uniqueIndex.add(i);
                        ArrayList<Integer> unique = new ArrayList<>();
                        unique.addAll(uniqueIndex);
                        res.add(unique);
                    }
                }
            }
        }
        return res;
    }
}
