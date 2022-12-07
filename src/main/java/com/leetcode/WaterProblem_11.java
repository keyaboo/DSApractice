package com.leetcode;

/**
 * @author christian
 * as is: O(n^2) solution that doesn't pass.
 * The O(n) one starts from both ends, computes area, moves the shorter of the two walls comparing area as it moves inward
 * TODO: implement the better solution
 */
public class WaterProblem_11 {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr));
		
		
	}

	
    public static int maxArea(int[] height) {
        int maxArea = 0;
	        for (int i = 0; i < height.length - 1; i++) {
	            for (int k = i + 1; k < height.length; k++) {
	                int area = Math.min(height[i], height[k]) * (k - i);
	                if (area > maxArea) {
	                    maxArea = area;
	                }
	            }
	        }
	        return maxArea;
	    }	      
	
}
