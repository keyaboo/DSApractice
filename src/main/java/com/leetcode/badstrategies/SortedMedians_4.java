package com.leetcode.badstrategies;

import java.util.ArrayList;

/**
 * @author christian
 * TODO: all of this is completely fubar, will return to this and other hard problems once I'm a little better
 */
public class SortedMedians_4 {

	public static void main(String[] args) {
		int[] nums1 = {1 , 6};
		
		int[] nums2 = {3 , 4, 5 , 7};
		int firstIndex = 0;
		int secondIndex = 0;
		boolean carry = (((nums1.length + nums2.length) % 2 == 0)) ? true: false;
		int medianIndex = (nums1.length + nums2.length) / 2;
		System.out.println("nums1.length=" + nums1.length);
		System.out.println("nums2.length=" + nums2.length);
		System.out.println("carry=" + carry + "medianIndex=" + medianIndex);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int i = 0; i < nums1.length + nums2.length; i++) {
			if ((nums1[firstIndex] < nums2[secondIndex])) {
				System.out.println("firstIndex=" + firstIndex);
				arr.add(nums1[firstIndex]);
				if (firstIndex < nums1.length - 1) {
				firstIndex++; 
				}
				
			} else if (nums2[secondIndex] < nums1[firstIndex]) {
				System.out.println("secondIndex=" + secondIndex);
				arr.add(nums2[secondIndex]);
				if (secondIndex < nums2.length - 1) secondIndex++; 
			} else if (firstIndex == nums1.length - 1 && secondIndex < nums2.length - 1) {
				System.out.println("secondIndex=" + secondIndex);
				arr.add(nums2[secondIndex]);
				secondIndex++; 
			} else if (secondIndex < nums2.length - 1 && (firstIndex < nums1.length - 1)) {
				System.out.println("firstIndex=" + firstIndex);
				arr.add(nums1[firstIndex]);
				firstIndex++; 
			}
		}
		for (int k = 0; k < arr.size(); k++) {
			System.out.println(arr.get(k));
		}
	}

}
