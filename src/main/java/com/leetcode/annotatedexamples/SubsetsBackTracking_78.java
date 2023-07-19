package com.leetcode.annotatedexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 * (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * starting index is part of the function for subset problem bc recursive calls want to begin elsewhere.
 * permutation backtracking start at 0 and do a check for presence already
 */
public class SubsetsBackTracking_78 {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        // in the backtracking algorithm, this first block represents the "goal"
        // you set up some condition, whether it's verifying that your tempList is equal in size to nums in size
        // for permutations, whether your start is equal to nums.length for palindrome partitioning.
        list.add(new ArrayList<>(tempList));
        // but here there's no condition, the list is appended to incrementally, and the resulting list
        // adds the temp list.
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
            // simply resetting the list, within the loop, it's a counter to the templist add.
            // the longer sequences are handled with the recursive backtrack call, the shorter ones (i.e. just one element
            // are generated from the original fn call - one element is added to the list, and then it is removed)
        }
    }
}
