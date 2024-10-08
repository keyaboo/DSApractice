package com.leetcode.accepted;

/**
 * seems I got the test cases correct with my only error really being trying Integer.valueOf() instead
 * of just subtracting the char values by '0', a cautionary tale of using standard library functions when you
 * don't know what they are. Actually not sure yet if my trim solution worked for the leading number.
 *
 * Could be done differently: use a swap for a and b to ensure that a is >= b in length instead of creating
 * new variables.
 *
 * accepted hell yeah.
 *
 * recommended solution doesn't compute sum, everything's just tacked onto carry. instead of sum equaling 3,2,1, or 0
 * you can just use remainder for carry term % 2. outside the loop if carry equals 1 you append onto it, which is what
 * I did. whether this is done with a trimmed char array or stringbuilder is something that can be practiced.
 *
 */
public class AddBinary_67 {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        String longer = (aLength >= bLength) ? a : b;
        String shorter = (a.equals(longer)) ? b : a;
        int offset = Math.abs(aLength - bLength);
        int carry = 0;
        char[] answer = new char[Math.max(aLength, bLength) + 1];
        for (int i = longer.length() - 1; i >= 0; i--) {
            int shortChar;
            if (i - offset < 0) {
                shortChar = 0;
            } else {
                shortChar = (shorter.charAt(i - offset) - '0');
            }
            int longChar = (longer.charAt(i) - '0');
            int sum = shortChar + longChar + carry;
            if (sum == 3) {
                answer[i+1] = '1';
                carry = 1;
            } else if (sum == 2) {
                answer[i+1] = '0';
                carry = 1;
            } else if (sum == 1) {
                answer[i+1] = '1';
                carry = 0;
            } else if (sum == 0) {
                answer[i+1] = '0';
                carry = 0;
            }
        }
        answer[0] = (carry == 1) ? '1' : ' ';
        return String.valueOf(answer).trim();

    }


}
