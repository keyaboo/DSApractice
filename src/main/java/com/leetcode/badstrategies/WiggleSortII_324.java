package com.leetcode.badstrategies;

import java.util.ArrayList;

/**
 * @author christian
 * not working, tried some dumb recursion without finding the median
 */
public class WiggleSortII_324 {

	public static void main(String[] args) {
		int[] nums = new int[] {1,3,2,2,3,1};
		int[] nums2 = {1,5,1,6,4,4};
		nums = wiggleSort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		
	}
	public static int[] wiggleSort(int[] nums) {
		ArrayList<Boolean> ineqUpheld = new ArrayList<Boolean>();
		for (int i = 0; i < nums.length - 1; i++) {
			Boolean inequality = (i % 2 == 0) ? (Boolean)gt(nums[i],nums[i+1]) : (Boolean) lt(nums[i],nums[i+1]);
			// System.out.println(inequality);
			ineqUpheld.add(inequality);
		}
		
		for (int k = 0; k < ineqUpheld.size(); k++) {
			// System.out.println(ineqUpheld.get(k));
			if (ineqUpheld.get(k)) {
				if ((k + 1) == ineqUpheld.size() && (nums[k] == nums[k+1])) {
					swap(k, k+1, nums);
				} else if ((nums[k] == nums[k+1]) && k == 0) {
					swap(k,k+2,nums);
				} else if (!((k + 1) == ineqUpheld.size() && k != 0 && nums[k] == nums[k+1])) {
					swap(k, k-1, nums);
				} else {	
					swap(k, k+1, nums);
					}
				}	
			
		}
		
		for (int i = 0; i < nums.length; i++) {
			// System.out.print(nums[i] +",");
		}
		
		for (int i = 0; i < nums.length - 1; i++) {
			Boolean inequality = (i % 2 == 0) ? (Boolean)gt(nums[i],nums[i+1]) : (Boolean) lt(nums[i],nums[i+1]);
			if (inequality == false) {
				wiggleSort(nums);
			} else {
				return nums;
			}
		}
		
		return null;
	}
	
	public static void swap(int i, int k, int[] arr) {
		int temp = arr[k];
		arr[k] = arr[i];
		arr[i] = temp;
	}
	
	public static boolean lt(int i, int k) {
		if (i < k) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean gt(int i, int k) {
		if (i > k) {
			return true;
		} else {
			return false;
		}

	}
	
}
