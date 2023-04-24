package com.leetcode.accepted;

import java.util.HashMap;

/**
 * this is a two pointer problem but I'm so accustomed to doing some kind of reset in the event of a
 * containskey and writing 'else', I wouldn't have thought to have used the map check as a conditional reset point
 * depending on the position of the new start point, and then counting or whatever business logic proceeds
 * regardless.
 *
 *
 */
public class LongestSubstring_03 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        // here j is the index of the repeat
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    // here re-doing with ascii array rather than hashmap
    // tip: so with this you want to make the distinction between loop index and character in string appearance
    // on the first letter you're looking at, the index is 0, but you don't necessarily want to
    // regard the first letter the same as unaccounted for, hence the +1's when updating the ascii array,
    // with the hashtable value 0 is distinct from empty, with this strategy there's the risk of conflating the two
    public int lengthOfLongestSubstring2(String s) {
        int[] asciiArray = new int[256];
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (asciiArray[s.charAt(i)] > 0) {
                j = Math.max(j, asciiArray[s.charAt(i)]);
                // the reason it's asciiArray[s.charAt(i)] alone and not +1 is because it's already accounted for below
                /*
                abcdaefg
                a will show up as 1 rather than 0, and there's no problem with arr['a'] being updated to 5
                later on because the new start already shows up in j moving.
                 */
            }
            asciiArray[s.charAt(i)] = i + 1;
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
