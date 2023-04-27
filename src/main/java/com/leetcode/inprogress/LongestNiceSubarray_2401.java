package com.leetcode.inprogress;

/**
 * cheated a little too much on longest subarray, doing this problem legit since it's similar.
 *
 * seems like for this one, an arraylist/vector can hold onto previous values where bitwise & was equal to zero.
 * max = Math.max(vec.length, max)
 *
 * I don't see a way of avoiding having to do every single comparison for inclusion into the vector, but perhaps
 * you could use bitwise addition to create a greedy unsigned int with all the locations of the 1's.
 *
 * 1) currentLongest, starts out at 0, beccomes 1 if bitwise & fails or is the first integer being processed.
 * 2) bitwise sum, starts out as 0 not because it's a counter but we want 0000000 (at first) to be our check at
 * the beginning for bitwise &. resets to whatever the number being looked at is in the event of a failure.
 * 3) max, what'll get returned
 *
 * well that worked for every 51/65 test cases except
 *
 * [84139415,693324769,614626365,497710833,615598711,264,65552,50331652,1,1048576,16384,544,270532608,151813349,221976871,678178917,845710321,751376227,331656525,739558112,267703680]
 *
 * where 8 was expected but it spit out 7, I suspect there's some hack I don't know about just gonna look at the answer.
 */
public class LongestNiceSubarray_2401 {
    public int longestNiceSubarray(int[] nums) {
        int max = 0;
        int currentLongest = 0;
        int bitwiseSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bitwiseSum) == 0) {
                currentLongest++;
                bitwiseSum = bitwiseSum | nums[i]; // this is what stores previous 1's.
            } else {
                currentLongest = 1;
                bitwiseSum = nums[i];
            }
            max = Math.max(max, currentLongest);
        }

        return max;
    }
}
