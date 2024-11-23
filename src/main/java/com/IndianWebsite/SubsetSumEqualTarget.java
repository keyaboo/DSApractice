package com.IndianWebsite;

/*
this is subset sum not subarray sum (which would be sliding window). this is pretty much identical to partition
equal subset sum.
 */
public class SubsetSumEqualTarget {
    static Boolean isSubsetSum(int arr[], int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = target; j >= arr[i]; j--) {
                dp[j] = ((dp[j]) || (dp[j - arr[i]]));
            }
        }
        return dp[target];
    }

    // less space optimized but still an intuitive dp problem:
    public boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true; // first column is all true
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean noTake = dp[i-1][target]; // refer to previous row's value
                boolean take = false;
                if (arr[i] <= target) { // this check is missing in the more optimized one.
                    take = dp[i -1][target - arr[i]];
                }
                dp[i][target] = take || noTake;
            }
        }
        return dp[n-1][k];
    }

}
