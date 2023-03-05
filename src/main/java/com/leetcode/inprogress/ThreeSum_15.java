package com.leetcode.inprogress;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;
import java.util.HashMap;

/*  so my thinking here is the following:
        loop over array, for each value create a new hashtable with the key being the index of a particular element,
        and the value being a linked list that stores the sum of the current value and subsequent values.

 */
public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

    }

    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        ArrayList<Hashtable<Integer,List<Integer>>> crazy = new ArrayList<Hashtable<Integer,List<Integer>>>();
        for (int i = 0; i < nums.length; i++) {
            Hashtable<Integer,List<Integer>> ith = new Hashtable<Integer,List<Integer>>();
            for (int k = 0; k < i; k++) {
                Hashtable<Integer,List<Integer>> getcrazy = crazy.get(k);

            }
        }
        return null;
    }


}
