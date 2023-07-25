package com.codeforces.accepted.MinimizePermutationSubarrays_1100;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * key point to notice is that 1 and 2 should be as far away from each other as possible.
 * also that the value equal to array length should be between 1 and 2
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
            int nIndex = 0, oneIndex = 0, twoIndex = 0;
            for (int j = 0; j < elements.length; j++) {
                if (elements[j] == 1) {
                    oneIndex = j;
                }
                if (elements[j] == 2) {
                    twoIndex = j;
                }
                if (elements[j] == elements.length) {
                    nIndex = j;
                }
            }
            // (12n) (n21) => (1n2), (2n1)
            if ((nIndex > twoIndex && twoIndex > oneIndex) || (oneIndex > twoIndex && twoIndex > nIndex)) {
                System.out.println((twoIndex + 1) + " " + (nIndex + 1));
            // (21n) (n12) => (2n1), (1n2)
            } else if ((oneIndex > twoIndex && nIndex > twoIndex && nIndex > oneIndex) ||
                    (twoIndex > oneIndex && twoIndex > nIndex && oneIndex > nIndex)){
                System.out.println((oneIndex + 1) + " " + (nIndex + 1));
            } else {
                System.out.println("1 1");
            }

        }
    }
}
