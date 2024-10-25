package com.leetcode.inprogress;

import java.util.Arrays;

public class MissingNumber_268 {
    /*
    the sum of an arithmetic series with n elements and the lowest number (a) being 0 is (n/2) * (2a + (n+1)).
    alternatively and probably better is to start with sum being the size of the array, subtract nums[i] and
    add i.
     */
    public int missingNumber(int[] nums) {
        int fullSeriesSum = (((2*0) + nums.length + 1) * (nums.length + 0)) / 2;
        for (int i = 0; i < nums.length; i++) {
            fullSeriesSum -= nums[i];
        }
        return fullSeriesSum;
    }


}
