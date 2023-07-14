package com.leetcode.accepted;

/*
    dp problem, find half of what the sum of all numbers is, use that number to initialize a boolean array. half that
    quantity is the
    2d more straightforward to understand since the loop order has a more legible what's going on:
    dp[i][j], whether the elements up to i can be summed up to j.
    Thinking about this spatially there are waaaaaay more j's to be checked, the reason not every number up to sum needs
    checking is that a sizeable number of j's have already been determined previously.
    the nums array doesn't need sorting which I was sort of surprised by.


    [3, 1, 4] -> 4 + 4 / 2 = 4

    [ 0  3  1  4 ]
      T  T  T
      F  F
      F  F
      F  T
      F  F

      this diagram is actually really hard to draw b/c the 2D matrix isn't aligned with nums[]

      ok summary of the 2d: use nums[i-1] to access the element of nums by iterating "i" times,
      but dp[i-1] is used for copying over previous columns.
 */
public class PartitionEqualSubsetSum_416 {
    public boolean canPartition2D(int[] nums) {
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
        // they have ot be because [j - nums[i - 1]] has to always be able to reach zero.
        // removing this because I think the 0,0 true copied over is sufficient.
        /*
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        */


        // my mental model for this was shit.
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j]; // in the ith column or whatever, everything from i - 1th column gets inherited
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]]; // check the previous column at the spot
                    // OR check the previous column with an offset equal to the nums value corresponding to the
                    // index you're on.
                }
            }
        }
        return dp[nums.length][sum];
    }

    /*
    shortened considerably, let's see what I got wrong
    dp[j] is the index, highest j is sum, the sum + 1 shit was for when the inner loop was going the other way.
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                dp[j] = ( dp[j] ) || (dp[j - nums[i - 1]]); // can loop with num:nums instead to avoid all this index shit;
            }
        }

        return dp[sum]; // equal subset sums after all, two of them
    }
}
