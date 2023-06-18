package com.codeforces.inprogress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * key point to notice is that 1 and 2 should be as far away from each other as possible.
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
            System.out.println("");
            permutationElements.add(elements);
        }
//        minimize(permutationElements);
    }

    private static void minimize(ArrayList<Integer[]> permutationElements) {
        for (int i = 0; i < permutationElements.size(); i++) {
            int oneIndex = permutationElements.indexOf(1);
            int twoIndex = permutationElements.indexOf(2);
            System.out.println("one index: " + oneIndex + " \ntwo index: " + twoIndex);
        }
    }
}
