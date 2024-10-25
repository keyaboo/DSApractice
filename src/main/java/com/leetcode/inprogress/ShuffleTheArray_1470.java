package com.leetcode.inprogress;

import java.util.LinkedList;
import java.util.Queue;

/*

 */
public class ShuffleTheArray_1470 {
    public int[] shuffle(int[] nums, int n) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            yQueue.offer(nums[i+n]);
            xQueue.offer(nums[i]);
            if (i % 2 == 0) {
                nums[i] = xQueue.poll();
            } else {
                nums[i] = yQueue.poll();
            }
        }
        for (int j = n; j < nums.length; j++) {
            if (j % 2 == 0) {
                nums[j] = xQueue.poll();
            } else {
                nums[j] = yQueue.poll();
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
