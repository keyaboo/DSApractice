package com.leetcode.inprogress;

import java.util.ArrayList;
import java.util.List;

/*
I had the do the same thing as the majority approach and then check whether both in fact appear with freq > n/3 but
thought there might be something sexier.
 */
public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int count0 = 0;
        int count1 = 0;
        int num0 = Integer.MIN_VALUE;
        int num1 ;
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (count0 == 0 && count1 == 0) {
                num0 = num; count0++;
            } else if (count0 > 0 && count1 == 0) {
                // num1 =
            }
        }
        int freq0 = 0;
        int freq1 = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == num0) {

            }
        }
        return res;
    }
}
