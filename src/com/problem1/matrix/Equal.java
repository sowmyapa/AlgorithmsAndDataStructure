package com.problem1.matrix;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/equal/problem
 */
public class Equal {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        for(int i=0;i<testCases;i++){
            int n = Integer.parseInt(in.nextLine());
            int[] input = new int[n];
            int min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                input[j] = in.nextInt();
                min = Math.min(min,input[j]);
            }
            if(in.hasNextLine())
                in.nextLine();
            findMinimum(input,min);
        }
    }

    public static void findMinimum(int[] input,int min){
        int finalSum=Integer.MAX_VALUE;
        for(int i=0;i<5;i++){
            int count=0;
            for(int j=0;j<input.length;j++){
                int delta = Math.abs(input[j]-(min-i));
                count += (delta/5) + (delta%5)/2 + ((delta%5)%2);
            }
            finalSum = Math.min(finalSum,count);
        }
        System.out.println(finalSum);
    }
}
