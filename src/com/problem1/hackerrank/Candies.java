package com.problem1.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/candies/problem
 */
public class Candies {

    static int candies(int n, int[] arr) {
        // Complete this function
        int[] dist = new int[n+1];
        int res=0;
        Arrays.fill(dist,1);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1])
                dist[i] = dist[i-1]+1;
        }
        for(int i =arr.length-2;i>=0;i--){
            if(arr[i]>arr[i+1])
                dist[i] = Math.max(dist[i],dist[i+1]+1);
        }
        for(int i=0;i<arr.length;i++){
            res+=dist[i];
        }
        return res;
    }

    /**
     * 10
     9 2 3 6 5 4 3 2 2 2
     2 1 2  5  4  3 2  1  1  1
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = candies(n, arr);
        System.out.println(result);
        in.close();
    }

}
