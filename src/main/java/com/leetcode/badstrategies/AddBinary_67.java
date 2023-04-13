package com.leetcode.badstrategies;

/**
 * this seems quite similar to merge 2 SL. start from string terminus, keep a "carry" flag variable, write some
 * simple logic to do 1 + 1 (carry = 0) = 0 carry = 1
 *
 * 111 + 11 = 0
 */
public class AddBinary_67 {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {
        int bPos = b.length() - 1;
        int aPos = a.length() - 1;
        int carry = 0;
        boolean aStopped = false;
        boolean bStopped = false;
        StringBuilder s = new StringBuilder();
        while ((aPos >= 0 || bPos >= 0) && carry > 0) {
            int aNum = (aStopped) ? 0 : charToInt(a.charAt(aPos));
            int bNum = (bStopped) ? 0 : charToInt(b.charAt(bPos));
            int sum = aNum + bNum + carry;
            if (sum > 1) {
                s.append('0');
                carry = sum - 1;
            } else if (sum == 1) {
                s.append('1');
                carry = 0;
            } else if (sum == 0) {
                s.append('0');
                carry = 0;
            }
            if (aPos > 0) {
                aPos--;
            } else {
                aStopped = true;
                // this is complete dogshit way better to just load 0's up on the shorter string.
            }
            if (bPos > 0) {
                bPos--;
            } else {
                bStopped = true;
            }
            if (aPos == 0 && bPos == 0 && carry == 0) {
                break;
            }
        }
        return s.reverse().toString();
    }

    /**
     * I'm pretty sure it's Integer.valueOf(String s) that accomplishes the same thing but in a realistic situation
     * I wouldn't remember exactly since there's no IDE lookup or w/e
     */
    public static int charToInt(char c) {
        if (c == '1') {
            return 1;
        } else {
            return 0;
        }
    }
}
