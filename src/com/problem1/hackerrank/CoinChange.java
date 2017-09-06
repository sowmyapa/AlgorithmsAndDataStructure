package com.problem1.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/coin-change/problem
 */
public class CoinChange {

    static long getWays(long n, long[] c){
        long[] numberOfWays = new long[(int)n+1];
        numberOfWays[0] = 1;
        for(long cent : c){
            for(int i=(int)cent;i<=n;i++){
                int remainder = i-(int)cent;
                numberOfWays[i]+=numberOfWays[remainder];
            }
        }
        return numberOfWays[(int)n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }

}
