package com.leetcode.badstrategies;

/**
 * failed on test case {13,13,20,0,8,9,9}
 *
 * wth
 * 6,9,3,8,14
 * 6,9,3,11,11
 * 6,9,7,7,11
 * 8,7
 *
 * Ok you're not actually supposed to move the values in the array around at all, I have recursion brain atm.
 * You're also not supposed to find the largest value at any point, only go along the loop and find out whether
 * the inclusion of new values increases the running average of the array or not. If it does, then by some process
 * of shifting values leftward which would ultimately the highest would end up in the first position, you would
 * find your answer.
 *
 *
 */
public class MinimizeMaxOfArray_2439 {
    public static void main(String[] args) {
        int[] nums = {6,9,3,8,14};

        int num = (20 + 13) / 2;
//        System.out.println(num + " plusone=" + (num + 1));

         System.out.println(minimizeArrayValue(nums));
    }

    public static int minimizeArrayValue(int[] nums) {
        int highestIndex = findArrayHighestIndex(nums);
        if (nums[0] == nums[highestIndex]) {
            return nums[0];
        }

            int lower = nums[highestIndex-1];
            int higher = nums[highestIndex];
            int sum = lower + higher;
            if ((sum % 2) == 1) {
                nums[highestIndex - 1] = (sum / 2)  + 1;
                nums[highestIndex] = (sum / 2);
            } else {
                nums[highestIndex - 1] = sum / 2;
                nums[highestIndex] = sum / 2;
            }
            // printarray(nums);
        return minimizeArrayValue(nums);

        }

        public static void printarray(int[] nums) {
            System.out.print("{");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + ", ");
            }
            System.out.println("}");

        }
    public static int findArrayHighestIndex(int[] nums) {
        int highest = nums[0];
        int highestIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > highest) {
                highest = nums[i];
                highestIndex = i;
            }
        }
        return highestIndex;
    }
}
