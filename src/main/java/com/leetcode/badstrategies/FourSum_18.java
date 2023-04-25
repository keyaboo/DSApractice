package com.leetcode.badstrategies;

import java.util.*;

/**
 * so start with a sort the same as 3-sum
 * 1,0,-1,0,-2,2 sorted is
 * -2, -1, 0, 0, 1, 2
 *
 * maybe this is just a mash-up of two sum and three-sum?
 * nah lol that didn't work at all.
 *
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> quads = new HashSet<>();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int right = nums.length - 1;
            int left = 0;
            while (left < right) {
                left = (left == i) ? left : left + 1;
                right = (right == i) ? right : right - 1;
                int sum = nums[left] + nums[i] + nums[right] - target;
                Set<Integer> triplet = new HashSet<>();
                triplet.add(left);
                triplet.add(i);
                triplet.add(right);
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
                map.put(sum, triplet);
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (map.containsKey(nums[k])) {
                if (!(map.get(nums[k]).contains(k))) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.addAll(map.get(nums[k]));
                    triplet.add(k);
                    quads.add(triplet);
                }
            }
        }
        List<List<Integer>> soln = new ArrayList<>();
        soln.addAll(soln);
        return soln;
    }
}
