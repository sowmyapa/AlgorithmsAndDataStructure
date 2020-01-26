package com.problem1.arrays;

import java.util.Arrays;

/**
 * Created by sowmyaparameshwara on 8/12/18.
 */
public class LongestIncreastPath_New {

    public static void main (String[] args)
    {
        int  mat[][] = { {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7} };
        System.out.println("Length of the longest path is " +
                finLongestOverAll(mat));
    }

    private static int finLongestOverAll(int[][] mat) {
        int[][] dp = new int[mat.length][mat.length];
        for(int i = 0 ; i<dp.length;i++) {
            Arrays.fill(dp[i],-1);
        }
        int result = 0;
        for ( int i = 0 ; i <mat.length;i++){
            for (int j=0;j<mat.length;j++) {
                if (dp[i][j] == -1)
                    dp[i][j] = findLongestForCell(dp, mat, i, j);
                if ( result < dp[i][j]) {
                    result = dp[i][j];
                }
            }
        }
        return result;
    }

    private static int findLongestForCell(int[][] dp, int[][] mat, int i, int j) {
        if (dp[i][j] != -1)
                return dp[i][j];
        if( i > 0 && mat[i][j]+1==mat[i-1][j]) {
            return 1 + findLongestForCell(dp, mat, i - 1, j);
        }
        if( i < mat.length-1 && mat[i][j]+1==mat[i+1][j]) {
            return 1 + findLongestForCell(dp, mat, i + 1, j);
        }
        if( j > 0 && mat[i][j]+1==mat[i][j-1]) {
            return 1 + findLongestForCell(dp, mat, i, j - 1);
        }
        if( j < mat.length-1 && mat[i][j]+1==mat[i][j+1]) {
            return 1 + findLongestForCell(dp, mat, i, j + 1);
        }
        return dp[i][j]=1;
    }

}
