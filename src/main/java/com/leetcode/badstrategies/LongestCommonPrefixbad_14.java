package com.leetcode.badstrategies;

/**
 * @author christian
 * very strange, but I think O(n) solution that uses recursion, probably spent way too long and made it overly complicated
 * some things to learn from this:
 * 1) be hesitant to use a counted variable with charAt because you might run into index out of bounds problems.
 * I just sort of winged it and made an index variable instead but this might not be the right thing to do.
 * 2) anticipate if there's an array that any of the things in it might be empty, or like in the comment down below
 * that whatever dynamic variables you try to use for the algorithm to potentially not exist, so empty array, array
 * with one element, etc.
 */
public class LongestCommonPrefixbad_14 {

	public static void main(String[] args) {
		String[] strs = new String[] { "flower","fkow"};
		String commonPrefix = longestCommonPrefix(strs);
		System.out.println(commonPrefix);
	}
	
	public static int comparison(String s, int counter, String pattern) {
		int index = counter - 1;
		if (index < 0) {
			return 0;
		}
		if (s.charAt(index) == pattern.charAt(index)) {
			return counter;
		} else {
			counter--;
			counter = comparison(s, counter, pattern);
			return counter;
		}
	}
	
	public static String longestCommonPrefix(String[] strs) {
		String s1 = null;
		String s2 = null;
		
		if (strs != null && strs.length > 0) {
			s1 = strs[0];
		} else {
            return null;
        }
		if (strs.length > 1) {
		s2 = strs[1];
		} else {
			return s1;
		}
		int smallerStringSize = (Math.min(s1.length(), s2.length()));
		int counter = 0;
		for (int i = 0; i < smallerStringSize; i++) {
			System.out.println(s1.charAt(i));
			System.out.println(s2.charAt(i));
			if (s1.charAt(i) == s2.charAt(i)) {
				counter++;
			} else {
				break;
			}
		}

		
		String pattern = s1.substring(0, counter);
		for (int i = 0; i < strs.length; i++) {
			String checkedString = strs[i];
			if (checkedString.isEmpty()) {
				return "";
			} else {
			counter = comparison(checkedString, counter, pattern);

			pattern = pattern.substring(0, counter);
			}
		}
		
		return pattern;
    }

}
