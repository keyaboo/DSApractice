package com.leetcode.accepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * faster solutions have the loop breaking when currentSum > target so even larger elements are not needlessly
 * calling backtrack. cuts down on the looping substantially.
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(res, tempList, candidates, 0, target, 0);
        // ok for the start variable, if you don't use one like for permutations, you'll get permutations!
        // which you don't always want. in some cases you want backtrack to start from the next element, in which
        // case start becomes i + 1, and here you might want to re-use same element so start with i.
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, int currentSum, int target, int start) {
        if (currentSum > target) {
            return;
        } else if (currentSum == target) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                // currentSum = currentSum + nums[i];
                // ^ BE CAREFUL when using variables like this inside of a for loop, it'll never make it to the larger numbers!
                backtrack(res, tempList, nums, currentSum + nums[i], target, i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
