package com.codeforces.accepted.Watermelon_800;


import java.util.Scanner;

public class Watermelon800 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight = sc.nextInt();
        isDivisibleEvenly(weight);
    }

    private static void isDivisibleEvenly(int weight) {
        if (weight >= 4 && weight % 2 == 0)
            System.out.println("YES");
        else {
            System.out.println("NO");
        }
    }
}
