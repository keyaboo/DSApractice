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
        int testCases = sc.nextInt();
        System.out.println(testCases);
        ArrayList<Integer[]> permutationElements = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            int permutationSize = sc.nextInt();
            System.out.println(permutationSize);
            Integer[] elements = new Integer[permutationSize];
            for (int j = 0; j < permutationSize; j++) {
                elements[j] = sc.nextInt();
                System.out.print(elements[j]);
            }
            permutationElements.add(elements);
        }
        minimize(permutationElements);
    }

    private static void minimize(ArrayList<Integer[]> permutationElements) {
        for (int i = 0; i < permutationElements.size(); i++) {
            Integer[] elements = permutationElements.get(i);
            int oneIndex = -1;
            int twoIndex = -1;
            for (int j = 0; j < elements.length; j++) {
                if (elements[j] == 1) {
                    oneIndex = j;
                } else if (elements[j] == 2) {
                    twoIndex = j;
                }
            }
            if (Math.abs(twoIndex - oneIndex) == elements.length - 1) {
                System.out.println("1 1");
            } else if (true) {

            }
            System.out.println("one index: " + oneIndex + " \ntwo index: " + twoIndex);

        }
    }
}
