package com.leetcode.badstrategies;

/**
 * permutation problem because 2 steps + 1 step isn't the same as 1 step + 2 steps
 * I suppose the loop would be how many initial steps of 2 would you want to start out with
 * subtract n by 2 * the index of whatever that number is and you're left with some remainder
 * my mind goes to the possibility of a nice recursive solution to this maybe but idk exactly
 * how to implement that.
 *
 * the following is nice to know but I'm pretty sure you're not supposed to use it to solve this.
 * my hunch about recursion was correct, but I'll need to read up more on how to implement such a
 * solution.
 *
 *  The number of ways you can choose a president, vice-president, and secretary from a class of seven students
 *  is P(7,3) = 7 × 6 × 5 = 210. This can also be written a 7!/(7-3)!.
 *  In general P(n,r) = n!/(n-r)!; This can this can be interpreted as arranging all n objects,
 *  and then removing the order of the (n-r) objects which are not chosen by dividing by the
 *  number of ways to arrange them.
 */
public class ClimbingStairs_70 {
    public static void main(String[] args){
        int x = 3;
        System.out.println(climbStairs(x));
        System.out.println(factorial(13));
    }

    public static int climbStairs(int n) {
        int total = 0;
//      System.out.println("n/2="+n/2);
        for (int i = 0; i < (n/2); i++) {
            System.out.println();
            int slots = n - 2*i;
            // arrange the ones among n different slots I guess?

            int npr = (factorial(slots))/(factorial(slots-2));
            total = total + npr;
        }
        return total;
    }

    public static int factorial(int n) {
        if (n <= 0) {
            return 1;
        }
        int fact = 1;
        for(int i = 0; i < n; i++) {
            fact = fact*i;
        }
        return fact;
    }

    /*
    public static int climbStairsRecursive(int n) {
        if (n == 0) {
            return 0;
        }   else if (n - 1 == 0) {
            return 1;
        }
        int val = n / 2;

        return (climbStairsRecursive(val));
    }

     */


}
