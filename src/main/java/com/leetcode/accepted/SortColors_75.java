package com.leetcode.accepted;


/**
 * for dutch national flag problem there are three pointers, low, mid, and high
 * low and mid start on zeroeth index, high starts on length - 1 index.
 *
 * high is only decremented if what's at i or mid is 2, mid swapped with pre-decremented high
 * low is only incremented if what's at i or mid is 0, mid swapped with pre-incremented low
 * if i/mid is 1, keep as is.
 *
 * the actual logic here is really easy but the trick with this is that the index needs to be less than or equal to
 * the high rather than nums.length- less than is bad per test case:
 * [2,0,1] => [1,0,2] where high is now 1. if the number at the index were 2 this wouldn't be a problem, but
 * another swap will be needed in order to do the sort.
 *
 * the other weird part is decrementing mid or i in the event of a two.
 *
 * [1,2,0] => [1,0,2], if a 0 appears in the back of the array, you need a way of finding out that it needs to do a low
 * switch, so by decrementing mid/index you revisit the number and make it possible to do a zero swap or nothing if
 * it's a 1.
 *
 */
public class SortColors_75 {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        for (int i = 0; i <= high; i++) {
            int num = nums[i];
            if (num == 0) {
                swap(nums, low, i);
                low++;
            } else if (num == 2) {
                swap(nums, high, i);
                high--;
                i--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
