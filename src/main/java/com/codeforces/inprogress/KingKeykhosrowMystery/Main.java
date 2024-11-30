package com.codeforces.inprogress.KingKeykhosrowMystery;

import java.util.Scanner;



    public class Main {
        public static void main(String[] args) {
            try {
                Scanner sc = new Scanner(System.in);
                while (sc.hasNext()) {

                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int smallest = Math.min(a,b);
                    int largest = Math.max(a,b);
                    System.out.println(findKey(smallest,largest));
                }


                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.exit(0);
            }

        }

        public static int findKey(int a, int b) {
            // System.out.println(lcm(a,b));
            int m = b;
            int lcm = lcm(a,b);
            for (int i = b; i < b + lcm; i++) {
                if (i % a == i % b) {
                    return i;
                }
            }
            return m;

        }

        public static int lcm(int a, int b) {
            return (a * b) / gcd(a, b);
        }

        public static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }


    }
