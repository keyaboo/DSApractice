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

}
