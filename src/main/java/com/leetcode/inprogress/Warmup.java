package com.leetcode.inprogress;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Warmup {
    // 217 reverse a string in place
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // 26 remove duplicates from sorted array.
    // note: only use i-1 for checking duplicates.
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }


    // 189 rotate array
    public void rotate(int[] nums, int k) {

    }

    // 645 set mismatch
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        HashSet<Integer> range = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            range.add(i);
        }
        HashSet<Integer> found = new HashSet<>();
        int dup = 0;
        for (int i = 0; i < nums.length; i++) {
            range.remove(nums[i]);
            if (!found.add(nums[i])) {
                dup = nums[i];
            }
        }
        int[] res = new int[] {dup, range.iterator().next()};
        return res;
    }

    // better solution that sorts the array in place. you know where everything should be so it's not O(n*log(n)) sort.
    // gist: loop through the array and look at the number. calculate where in the array the number would be if
    // it were sorted. compare the number you're looking at to the number sitting at that index. if they're
    // not equal swap them, otherwise proceed to the next element in the array. When the array has been sorted
    // like this, loop through it and verify that the value you're looking at is idx + 1. If it isn't, the
    // missing value is idx + 1 and the duplicate is the present value.
    public int[] findErrorNums2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1; // calculates index where present number nums[i] should* be placed
            if (nums[correctIndex] != nums[i]) { // determines whether nums of the calculated index actually holds the
                int temp = nums[i]; // number you're looking at.
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return new int[] {nums[j], j+1}; // i + 1 is the expectant missing number, nums[j] is the value out
            } // out of place and therefore a duplicate.
        }

        return new int[0];
    }

    // 643 maximum average subarray : recast everything as doubles
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0.0d;
        for (int i = 0; i < k; i++) {
            avg += ((double) nums[i])/k;
        }
        double maxAvg = avg;
        for (int i = k; i < nums.length; i++) {
            int dropped = i - k;
            avg += ((double) nums[i] - (double) nums[dropped]) / k;
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }

    // 1752 check if array is sorted and rotated
    // the trick is that the last check will determine whether the numbers at the beginning
    // really were all larger than the numbers after a supposed pivot. comparing adjacent terms
    // doesn't give you this info.
    public boolean check(int[] nums) {
        int rotates = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > (nums[(i + 1) % nums.length])) {
                rotates++;
            }
            if (rotates > 1) {
                return false;
            }
        }
        return true;
    }

    // 2124
    public boolean checkString(String s) {
        boolean foundB = s.charAt(0) == 'b';
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'a' && foundB) {
                return false;
            } else if (s.charAt(i) == 'b') {
                foundB = true;
            }
        }
        return true;
    }

    // 1653 Minimum Deletions to Make String Balanced
    public int minimumDeletions(String s) {
        HashMap<Integer, Integer> priorB = new HashMap<>();
        HashMap<Integer, Integer> posteriorA = new HashMap<>();
        int foundB = 0;
        int foundA = 0;
        int left = 0;
        int right = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            priorB.put(i, foundB);
            if (s.charAt(i) == 'b') {
                foundB++;
            }
        }
        for (int j = s.length() - 1; j>=0; j--) {
            posteriorA.put(j, foundA);
            if (s.charAt(j) == 'a') {
                foundA++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            min = Math.min(min, Math.min(posteriorA.get(i),priorB.get(i)));
        }
        return min;
    }

    // 88 merge sorted array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

    // 28 Find index of the first occurrence in a string - got thrown off at the 1-off.
    public int strStr(String haystack, String needle) {
        int needleSize = needle.length();
        if (haystack.length() < needleSize) return -1;
        for (int i = 0; i <= haystack.length() - needleSize; i++) {
            int j = 0;
            while (haystack.charAt(i+j) == needle.charAt(j) && (j < needleSize)) {
                j++;
                if (j == needleSize) return i;
            }
        }
        return -1;
    }

    // 977 Squares of a sorted Array
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int idx = res.length - 1; idx >= 0; idx--)  {
            if ((Math.abs(nums[left]) > Math.abs(nums[right]) || Math.abs(nums[left]) == Math.abs(nums[right]))) {
                res[idx] = nums[left] * nums[left];
                left++;
            } else if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[idx] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }


    // 283 Move Zeroes : easy with a queue
    public void moveZeroes(int[] nums) {
        int z = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                z++;
            } else {
                if (z > 0) {
                    nums[i-z] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }


    // 27 Remove Element
    public int removeElement(int[] nums, int val) {
        int trailingIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[trailingIndex] = nums[i];
                trailingIndex++;
            }
        }
        return trailingIndex;
    }

    // TODO:
    // 53 Maximum Subarray
    // 215 kth largest element in an array









































}
