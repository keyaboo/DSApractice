package com.codeforces.accepted.TheatreSquare_1000;

import java.util.Scanner;

/*
the 10^9 inputs threw me off, can obviously exceed that value and integers if things are getting multiplied.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, a;
        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();
        System.out.println(minimizeFlagstones(n, m, a));
    }

    private static long minimizeFlagstones(int n, int m, int a) {
        int extraWidth = (m % a) > 0 ? 1 : 0;
        int extraHeight = (n % a) > 0 ? 1 : 0;
        long width = (m / a) + extraWidth;
        long height = (n / a) + extraHeight;
        return width * height;
    }
}
