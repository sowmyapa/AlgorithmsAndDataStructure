package com.problem1.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-the-matrix/problem
 */
public class MatrixSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        in.nextLine();
        for(int i=0; i<q ;i++){
            int n = in.nextInt();
            in.nextLine();
            int[][] matrix = new int[2*n][2*n];
            for(int j=0;j<2*n;j++){
                for(int k=0; k<2*n; k++){
                    matrix[j][k] = in.nextInt();
                }
            }
            int sum=0;
            for(int j=0;j<n;j++){
                for(int k=0; k<n; k++){
                    matrix[j][k] = Math.max(Math.max(matrix[j][k],matrix[j][2*n-1-k]), Math.max(matrix[2*n-1-j][k],matrix[2*n-1-j][2*n-1-k]));
                    sum+=matrix[j][k];
                }
            }
            System.out.println(sum);
        }
    }

}
