package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author christian
 * this one just really needed a better whiteboarding strategy.
 */
public class LongestSubstring_03 {

	public static void main(String[] args) {
		String s = "jbpnbwwd";
        Integer longest = (s.length() > 0) ? 1 : 0;	
		
		for (int i = 0; i < s.length(); i++) {
			Integer templength = 1;
			char c = s.charAt(i);
			System.out.println("c=" + c );
			int j = 1;
			int k = 1;
			ArrayList<Character> arr = new ArrayList<Character>();
			arr.add(c);
			boolean stay = true;
			while ((!(i - j <= 0) || !(i + k >= s.length())) && stay) {
				Character d = !(i - j <= 0) ? s.charAt(i - j) : null;
				Character e = !(i + k >= s.length()) ? s.charAt(i + k) : null;
				// System.out.println("contains e=" + arr.contains(e) + " e=" + e);
				
				if ((d == null && arr.contains(e) && e==null && arr.contains(d))) { System.out.println("templength=" + templength); stay = false;}

				if (d != null && (!arr.contains(d))) { arr.add(d); templength++; System.out.println("backwards addn");}
				if (e != null && (!arr.contains(e))) { arr.add(e); templength++; System.out.println("forwards addn"); }
				longest = (templength > longest) ? templength : longest;
				 j++;
				 k++;
			}
			System.out.println(templength);
		}
		System.out.println(longest);
            
        

		
	}
	
	

}
