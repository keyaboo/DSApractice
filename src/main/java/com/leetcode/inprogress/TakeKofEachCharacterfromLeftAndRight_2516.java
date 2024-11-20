package com.leetcode.inprogress;

/*
Sliding window is the other technique that accomplishes this task in O(n) rather than O(n^2), that's all I know.
I think you keep moving right until counts[0-2] are all >= k, and then start decrementing by moving left forward.
You could do right is modulo whatever it normally is. The stop condition would be left == n.

No, rather than incrementing you decrement from the counts array, only moving left if the window is so big that
the counts of the things not in the window dip below k.
 */
public class TakeKofEachCharacterfromLeftAndRight_2516 {
    public int takeCharacters(String s, int k) {
        int[] counts = new int[3];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            counts[c]++;
        }
        if (counts[0] < k || counts[1] < k || counts[2] < k) {
            return -1;
        }
        int[] exclusionWindow = new int[3];

        int left = 0;
        int largestWindow = 0;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            exclusionWindow[c]++;
            while (left <= right &&
                    (counts[0] - exclusionWindow[0] < k || (counts[1] - exclusionWindow[1] < k) || (counts[2] - exclusionWindow[2] < k))) {
                exclusionWindow[s.charAt(left) - 'a']--;
                left++;
            }
            int size = right - left + 1;
            largestWindow = Math.max(largestWindow, size);
        }
        return s.length() - largestWindow;
    }
}
