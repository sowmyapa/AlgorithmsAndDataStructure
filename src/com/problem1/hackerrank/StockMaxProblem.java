package com.problem1.hackerrank;

import java.util.Scanner;
/**
 * https://www.hackerrank.com/challenges/stockmax/problem
 */
public class StockMaxProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(getMaxProfit(arr));
        }
        in.close();
    }


    public static long getMaxProfit(int[] prices) {
        long profit = 0l;
        int maxSoFar = 0;
        for(int i=prices.length-1;i>=0;i--){
            if(maxSoFar<prices[i]){
                maxSoFar = prices[i];
            }
            profit += (maxSoFar-prices[i]);
        }
        return profit;
    }
}
