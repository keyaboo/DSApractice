package com.leetcode.inprogress;

public class JumpGameII_45 {
    public int jump(int[] nums) {
        int count = 0;
        int i = 0;
        int j = nums[0];
        while (i + j < nums.length - 1) {
            int furthestJump = Integer.MIN_VALUE;
            for (int k = 0; k < j; k++) {
                if (nums[i + k] != 0) {
                    furthestJump = Math.max(furthestJump, nums[i + k]);
                }
            }
            count++;
            if (i + furthestJump == (nums.length - 1)) {
                return count;
            }
            i = i + furthestJump;
            j = nums[i];
        }
        return 0;
    }
}
