package com.leetcode.suboptimalsolutions;

/**
 * figuring out when to move left so you don't end up with O(n^2)
 *
 *
 * -2 X X X 5
 * logic should include 5, add it to running sum, and then remove -2, but that's not how to think about it.
 *
 * [ 4 -2 1 2 ]
 * hard to think of a check for this, because you want to include -2. My O(n^2) crappy attempt at this
 * problem checked if the running sum was > 0 with right + 1's inclusion, but there's nothing special
 * about 0 since all numbers are bounded -10^4 on the lower end.
 *
 * ^^ wrong, so dumb, since it's the largest sum of the subarray, and if only negative values were included
 * your answer wouldn't be a subarray, just the largest negative # in the list.
 * I got every test case with that last one except the obnoxious O(n^2) check so it had some merit.
 *
 * [ 1 3 2 -11 -7 ]
 * for a real bad value at right + 1 (i.e. brings running sum down negative),
 * maybe use a while loop to move left until it equals right at the penultimate stinker value.
 * I suppose you could do the same whenever right = nums.length - 1
 * the currentSum can be modified with each value of left moving in, I guess max check
 *
 * first go at this had a time limit exceeded, so the loop isn't terminating somehow
 *
 * ^ I tried breaking by being cute and trying to push right to equal nums.length, bad idea. (<- not the problem)
 *
 * the real problem was not bounding 0 correctly, changed right forward conditionals to >= 0.
 *
 * next problem was a leading negative being brought along for the entire thing. the X's example
 * at the beginning would never actually happen. but w/e, first dynamic SW problem they'll
 * get easier.
 *
 * not even kind of the right approach here haha.
 *
 */
public class MaximumSubarray_53 {
    public static void main(String[] args) {
        // I hate having to do this but it seems there's an infinite sum somewhere.
        int[] nums = {31,-41,59,26,-53,58,97,-93,-23,84};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int currentSum = nums[left]; // would be nice to not have to instantiate these but w/e
        int highestSum = nums[left]; // turns out you can, Integer.MIN_VALUE
        while (right < nums.length) {
            if (left == right) {
                currentSum = nums[left];
                highestSum = (currentSum > highestSum) ? currentSum : highestSum;
                if (right < nums.length - 1 && currentSum + nums[right + 1] < 0 || currentSum < 0) {
                    left++;
                    right++;
                } else if (right < nums.length - 1 && currentSum + nums[right + 1] >= 0) {
                    currentSum += nums[right + 1];
                    highestSum = (currentSum > highestSum) ? currentSum : highestSum;
                    right++;
                } else {
                    right++;
                }
                // right terminating at nums.length - 1, this is kinda tricky
            } else if (right > left) {
                if (right < nums.length - 1 && currentSum + nums[right + 1] >= 0) {
                    currentSum += nums[right + 1];
                    highestSum = (currentSum > highestSum) ? currentSum : highestSum;
                    right++;
                } else if ((right < nums.length - 1 && currentSum + nums[right + 1] < 0) || right == nums.length - 1) {
                    while (left < right) {
                        currentSum = currentSum - nums[left];
                        highestSum = (currentSum > highestSum) ? currentSum : highestSum;
                        left++;
                    }
                }

            }
        }
        return highestSum;
    }

}
