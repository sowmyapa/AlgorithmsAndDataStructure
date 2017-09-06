package com.problem1.matrix;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 9/2/17.
 */
public class RotateMatrix {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = 4;

        // Test Case 1
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };


        // Tese Case 2
        /* int mat[][] = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
         */

        // Tese Case 3
        /*int mat[][] = {
                        {1, 2},
                        {4, 5}
                    };*/

        // displayMatrix(mat);

        rotateMatrix(N,mat);
        displayMatrix(mat);
    }

    private static void displayMatrix(int[][] mat) {
        for(int i=0; i <mat.length;i++){
            for(int j=0;j<mat.length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotateMatrix(int n, int[][] mat) {
        for(int i = 0 ; i< n/2;i++){
            for(int j=i; j<n-1-i;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][n-1-i];
                mat[j][n-1-i] = mat[n-1-i][n-1-j];
                mat[n-1-i][n-1-j] = mat[n-1-j][i];
                mat[n-1-j][i] = temp;
            }
        }
    }

}
