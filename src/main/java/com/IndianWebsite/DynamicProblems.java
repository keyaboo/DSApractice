package com.IndianWebsite;

public class DynamicProblems {
    // climb 1 or 2 steps: lesson here is that dp array size is n+1 in problems where the subproblem is defined
    // as reaching a certain position or index and base case is at index 0.
    // if subproblems are defined in terms of input elements themselves like in this problem, dp array is n
    // the same dimensions as the input of the problem.
    public int minimumEnergy(int[] arr, int N) {
        if (N == 1) return 0; // originally returned arr[0] but that's wrong
        int[] dp = new int[N];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        if (N == 2) {
            return dp[1];
        }
        for (int i = 2; i < N; i++) {
            int twoStep = Math.abs(arr[i] - arr[i-2]);
            int oneStep = Math.abs(arr[i] - arr[i-1]);
            dp[i] = Math.min(dp[i-1] + oneStep, dp[i-2] + twoStep);
            // before I compared only the step differential for assigning dp[i] while failing to account for scenarios
            // where the path length (dp[i-1]/dp[i-2]) differential is also important.
        }
        return dp[N - 1];
    }



    public int minimizeCost(int k, int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; (i-j >= 0) && j <= k; j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + Math.abs(arr[i] - arr[i-j])); // second term was arr[j] that's wrong
            }
        }
        return dp[n-1];
    }

/*
house robber I: maximum sum of non-adjacent elements LC 198
the max index is either at dp[n-1] or dp[n-2].
The decision at each step is whether to rob the current house or skip it.
This is space inefficient using the extra array but whatever.
 */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); // you cannot rob adjacent houses, so dp[1] should be max of nums[0], nums[1]
        for (int i = 2; i < n; i++) {
                if (i - 2 >= 0) {
                    dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
                }
        }
        return Math.max(dp[n-1], dp[n-2]);
    }


    /*
    same problem except no reason to hardcode base cases, access things modulo n. Except stuff from the back isn't
    going to show up as a modulo in the base case. Really just two loops this isn't that interesting.
     */
    private class HouseRobberII_213 {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            // else if (n == 2) return Math.max(nums[0], nums[1]);
            // else if (n == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
            return Math.max(rob(nums, 0, n-1), rob(nums, 1, n));
        }

        public int rob(int[] nums, int left, int right) {
            int n = right - left;
            int[] dp = new int[n];
            dp[0] = nums[left];
            dp[1] = Math.max(nums[left], nums[left+1]);
            for (int i = left + 2; i < right; i++) {
                dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
            }
            return Math.max(dp[n-1], dp[n-2]);
        }
    /* ok this is space optimized, include represents the maximum amount of money you can rob if you include the
     current house at nums[i]. exclude represents the maximum amount of money if you exclude the current house.
     include would be would be the loot from before the previous one prevExclude, dp[i-2], plus nums[i]. By skipping
     the current house, the maximum loot would be the maximum of both previous iterations robbing and skipping
     options. After considering everything, the final result is the max of include and exclude.
     */
        public int robConstantSpace(int[] nums, int low, int high) {
            int include = 0;
            int exclude = 0;
            for (int i = low; i <= high; i++) {
                int prevInclude = include;
                int prevExclude = exclude;
                include = prevExclude + nums[i];
                exclude = Math.max(prevExclude, prevInclude);
            }
            return Math.max(include, exclude);
        }
    }
}
