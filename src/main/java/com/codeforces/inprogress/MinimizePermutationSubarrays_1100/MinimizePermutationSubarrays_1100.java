package com.codeforces.inprogress.MinimizePermutationSubarrays_1100;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * key point to notice is that 1 and 2 should be as far away from each other as possible.
 * X X X 1 X 2 X X
 * take min of (one/twoindex)
 * find abs of one/two index
 * find difference of array.length - 1 - math(one/twoindex)
 */
public class MinimizePermutationSubarrays_1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int testCases = sc.nextInt();
            ArrayList<Integer[]> permutationElements = new ArrayList<>();
            for (int i = 0; i < testCases; i++) {
                int permutationSize = sc.nextInt();
                Integer[] elements = new Integer[permutationSize];
                for (int j = 0; j < permutationSize; j++) {
                    elements[j] = sc.nextInt();
                }
                permutationElements.add(elements);
            }
            minimize(permutationElements);
        }
    }

    private static void minimize(ArrayList<Integer[]> permutationElements) {
        for (int i = 0; i < permutationElements.size(); i++) {
            Integer[] elements = permutationElements.get(i);
            int oneIndex = -1;
            int twoIndex = -1;
            int threeIndex = -1;
            for (int j = 0; j < elements.length; j++) {
                switch(elements[j]) {
                    case (1):
                        oneIndex = j;
                    case (2):
                        twoIndex = j;
                    case (3):
                        threeIndex = j;
                }
            }
            int smaller = Math.min(oneIndex, twoIndex);
            int larger = Math.max(oneIndex, twoIndex);
            int midPoint = ((elements.length - 1) % 2 == 0) ? (elements.length - 1) / 2 : ((elements.length - 1) / 2) + 1;
            if (Math.abs(twoIndex - oneIndex) == elements.length - 1) {
                System.out.println("1 1");
            } else if ((oneIndex <= midPoint && twoIndex <= midPoint)) {
                System.out.println((Math.max(oneIndex, twoIndex) + 1) + " " + elements.length);
            } else if ((oneIndex >= midPoint && twoIndex >= midPoint)) {
                System.out.println("1 " + (Math.min(oneIndex, twoIndex) + 1));
            } else if ((larger - smaller) <= smaller) {
                System.out.println(larger + 1 + " " + elements.length);
            } else {
                System.out.println("1 " + smaller + 1);
//                System.out.println("one index: " + oneIndex + " \ntwo index: " + twoIndex);
            }

        }
    }
}
