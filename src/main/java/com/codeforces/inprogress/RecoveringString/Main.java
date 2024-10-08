package com.codeforces.inprogress.RecoveringString;

import java.util.Scanner;
/*
    difference between number and 26, if it's negative, subtract 1 to number and add 'a' to stringbuilder
    maybe go the other way.
    check if it's gt 2. and then check if it's gt or eq to 1. 'auz'
    >= 2: add z to end
    < 2:
    z needs to be known about first.

 */
public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int lex = sc.nextInt();
                    recoverLexiSmallest(lex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }

    }

    // 3 => aaa. 3 - 26 < 0 dec int a by 1, add 'a' to sb?
    // while (a > 0)
    // subtract 26
    // > 26 ? line above
    //
    private static void recoverLexiSmallest(int a) {
        StringBuilder stringBuilder = new StringBuilder();

        char c;

    }
}