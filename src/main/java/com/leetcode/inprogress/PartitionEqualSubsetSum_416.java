package com.leetcode.inprogress;

/*
    dp problem, find half of what the sum of all numbers is, use that number to initialize a boolean array. half that
    quantity is the
    2d more straightforward to understand since the loop order has a more legible what's going on:
    dp[i][j], whether the elements up to i can be summed up to j.
    Thinking about this spatially there are waaaaaay more j's to be checked, the reason not every number up to sum needs
    checking is that a sizeable number of j's have already been determined previously.
    the nums array doesn't need sorting which is
 */
public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // check if sum is even
        if (sum % 2 != 0) {
            return false;
        }
        // half what the sum is up to now is the quantity we want to work with.
        sum = sum / 2;

        boolean[][] dp = new boolean[nums.length][sum + 1];
        // have to initialize this
        dp[0][0] = true;
        // not sure why dp[i][0] have to all be set to true.
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][sum];
    }
}
