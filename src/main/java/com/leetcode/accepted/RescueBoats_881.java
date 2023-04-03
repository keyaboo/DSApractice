package com.leetcode.accepted;

import java.util.Arrays;

/**
 * first intuition is to sort the people and do 2 pointer for matching the heaviest with lightest assuming the
 * heaviest don't need their own boat. I sort of doubt the O(nlogn) solution they'll care for too much.
 *
 * hopefully by reviewing the solution titles I can learn about some DS that provides a better way to do this.
 *
 * nvm that was the correct approach after all, not sure why this was a medium.
 */
public class RescueBoats_881 {

    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        int total = numRescueBoats(people,3);
        System.out.print(total);
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boatCounter = 0;
        int left = 0;
        int right = people.length-1;
        while (left<=right) {
            if (people[left] + people[right] <= limit) {
                boatCounter++;
                left++;
                right--;
            } else {
                boatCounter++;
                right--;
            }
        }
        System.out.println("debug");
        return boatCounter;
    }
}
