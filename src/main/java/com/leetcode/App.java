package com.leetcode;

import java.util.Hashtable;

public class App 
{
	
	private static String longestPalindrome(String s) {
		Hashtable<Integer, Character> ht = new Hashtable<>();
		for (int i = 0; i < s.length(); i++) {
			ht.put(i, s.charAt(i));
		}
		
		int longest_fan = 0;
		int longest_index = 0;
		
		
		int lower;
		int upper;

		
		for (int index = 1; index < s.length() && index < 1000; index++) {
			
			
			if ((compare(index,index+1,ht) && (!(index+1 > s.length())))) {
				
				for (int fan = 0; fan < 600 && (index - fan >= 0) && (index + fan + 1 < s.length()); fan++) {
					lower = index - fan;
					upper = index + fan + 1;
					
					if ((compare(upper,lower,ht)) && (upper - lower > longest_fan)) {
						// longest_fan = upper - lower;
						longest_fan = fan;
						longest_index = index;
						System.out.println("achieved!");
					}

				}
				System.out.println(longest_index);
				System.out.println(longest_fan);
				return s.substring(longest_index - longest_fan, longest_index + longest_fan + 1);
			}
			
			
			else {
				for (int fan = 0; fan < 600 && (index - fan >= 0) && (index + fan < s.length()); fan++) {
					lower = index - fan;
					upper = index + fan;

					if ((compare(upper,lower,ht)) && (upper - lower > longest_fan)) {
						// longest_fan = upper - lower;
						longest_fan = fan;
						longest_index = index;
						System.out.println("achieved!");
					}

					
				}
				
				return s.substring(longest_index - longest_fan, longest_index + longest_fan);

			}
			
			
		}
		return null;
	}
			
			/*
				
			else {

			
			for (int fan = 0; fan < 600 && (index - fan >= 0) && (index + fan < s.length()); fan++) {
				
				
				
				if ((compare(index,index+1,ht) && (!(index+1 > s.length())))) {
					lower = index - fan;
					upper = index + fan + 1;
					
					if (compare(upper,lower,ht)) {
						
					}

					
					System.out.print("smaller achieved");
				}
				
				else if ((compare(upper,lower,ht) == true) && (upper - lower > longest_fan)) {
					// longest_fan = upper - lower;
					longest_fan = fan;
					longest_index = index;
					System.out.println("achieved!");
				}
				System.out.println("index=" + index + "lower=" + lower + " upper=" + upper);
				System.out.println(compare(upper, lower, ht));
			}
				
			return s.substring(longest_index - longest_fan, longest_index + longest_fan + 1);

		}
			
		}
		
		
		
		
	}
	
	*/
	
	private static boolean compare(int index1, int index2, Hashtable<Integer, Character> ht) {
		if (ht.get(index1).equals(ht.get(index2))) {
			return true;
		}		
		return false;
	}
	
	
    public static void main( String[] args )
    {
        String s = "Blqoolp";
        System.out.println(longestPalindrome(s));
    }
}
