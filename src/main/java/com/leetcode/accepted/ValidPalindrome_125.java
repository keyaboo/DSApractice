package com.leetcode.accepted;

public class ValidPalindrome_125 {
    /**
     * the ^ has to be inside of the brackets, and it specified in teh description elimination of all non-alphanumeric
     * characters. This is supposedly not a terribly well-optimized solution.
     * @param args
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String test2 = "zaz";
        String test3 = "0P";
        System.out.println(isPalindrome(test3));
    }

    public static boolean isPalindrome(String s) {
        String q = s.replaceAll("[^A-Za-z0-9]","");
        String test = q.toLowerCase();

        int howFarBack = 0;
        if (test.length() % 2 == 0) {
            howFarBack = 1;
        }
        int midpoint = test.length() / 2;
        // zz charat(1)
        // aza charat(1)
        int counter = 0;
        while(midpoint + counter < test.length()) {
                if (test.charAt(midpoint-howFarBack-counter) != (test.charAt(midpoint + counter))) {
                    return false;
                }
                counter++;
            }
        return true;

    }

    /**
     * going to repeat using 2 pointer approach to see if the score I get is better
     * actually who cares
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length();
        while (left <= right) {
        }
        return true;
    }



}
