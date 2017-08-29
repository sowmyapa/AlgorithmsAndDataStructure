package com.problem1.greedy;

import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/two-arrays/problem
 */
public class PermutingTwoArrays {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfQueries= in.nextInt();
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < numberOfQueries; i++){
            in.nextLine();
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();

            int[] arrA = new int[n];
            for(int j=0;j<n;j++){
                arrA[j] = in.nextInt();
            }
            in.nextLine();
            int[] arrB = new int[n];
            for(int j=0;j<n;j++){
                arrB[j] = in.nextInt();
            }
            permutation(arrA,arrB,result,k);

        }
        System.out.println(result.toString());

    }

    private static void permutation(int[] arrA, int[] arrB, StringBuilder result, int k) {
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        for(int i=0,j=arrB.length-1;i<arrA.length;i++,j--){
            if(arrA[i]+arrB[j]>=k){
                continue;
            }else{
                result.append("NO\n");
                return;
            }
        }
        result.append("YES\n");
    }

}