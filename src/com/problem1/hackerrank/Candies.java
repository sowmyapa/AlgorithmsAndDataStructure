package com.problem1.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by sowmyaparameshwara on 9/5/17.
 */
public class Candies {

    static int candies(int n, int[] arr) {
        // Complete this function
        int res,cur;
        int[] dist = new int[arr.length];
        dist[0] = 1;
        res = arr[0];
        for(int i=1;i<arr.length;i++){
            cur = arr[i]>arr[i-1]?dist[i-1]+1:1;
            dist[i]=cur;
            res+=cur;
        }
        return res;
    }

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
