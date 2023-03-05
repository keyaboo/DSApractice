package com.leetcode.accepted;

public class TwoSumII_167 {
    public static void main(String[] args){
        int [] numbers = {2,7,11,15};
        int target = 9;
        int [] answer = twoSum(numbers,target);
        System.out.println("{" + answer[0] + "," + answer[1] + "}");
    }

    public static int[] twoSum(int[] numbers, int target){
        int left = 0;
        int right = numbers.length - 1;
        while (left != right) {
            int leftnum = numbers[left];
            int rightnum = numbers[right];
            int theirsum = leftnum + rightnum;
            if (target - theirsum > 0) {
                left++;
            } else if (target - theirsum < 0) {
                right--;
            } else if (target - theirsum == 0) {
                int[] answer = {left+1,right+1}; // okay whatever 1-indexed I didn't read the problem very carefully
                return answer;
            }
            System.out.println(right);
        }
        return null;
    }
}
