package com.hackerrank.accepted;

import java.util.ArrayList;
import java.util.List;

/**
 * I don't really care for HR as much.
 */
public class ArrayLeftRotation {

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int shift = d % arr.size();
        List<Integer> solution = new ArrayList<>();
        for (int i = shift; i < arr.size(); i++) {
             solution.add(arr.get(i));
        }
        for (int i = 0; i < shift; i++) {
            solution.add(arr.get(i));
        }
        return solution;
    }
}
