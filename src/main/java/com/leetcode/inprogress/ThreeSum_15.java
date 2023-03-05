package com.leetcode.inprogress;
import java.util.*;

/*  so my thinking here is the following:
        loop over array, for each value create a new hashtable with the key being the index of a particular element,
        and the value being a linked list that stores the sum of the current value and subsequent values.

        no that's bad sort it instead.

        had no idea how to diagnose an infinite loop I caused ** because I was stupid
        
 */
public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> triplets = threeSumBruteForce(nums);
    }

    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> tripletsSet = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            while (!(left == right)) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    // System.out.println("{" +nums[i] + ", " +  nums[left] + ", " + nums[right] + "}");
                    tripletsSet.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    break; // LMAO I needed break here instead of continue
                }
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
            }
        }
        return new ArrayList<List<Integer>>(tripletsSet);
    }


}
