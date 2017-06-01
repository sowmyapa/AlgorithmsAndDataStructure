package com.problem1.arrays;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 3/9/17.
 *
 * (Largest block)

 Given a square matrix with the elements 0 or 1, write a program to find a maximum square submatrix whose elements are all 1s. Your program should prompt the user to enter the number of rows in the matrix.
 The program then displays the location of the first element in the maximum square submatrix and the number of the rows in the submatrix.
 Here is a sample run:

 Enter the number of rows in the matrix:

 5
 Enter the matrix row by row:

 1 0 1 0 1
 1 1 1 0 1
 1 0 1 1 1
 1 0 1 1 1
 1 0 1 1 1
 The maximum square submatrix is at (2, 2) with size 3

 It is a matrix of size 5. We create two temporary arrays to record the previous and current memoization:

 int[] previous = new int[5];
 int[] current = new int[5];
 Now, we compute the values for the current memoization - it works like this:

 if the cell in the current column is not set, then the square at the current position is size 0.
 if the cell is set, then it is 1 more than the smallest square above , above-left, or left of it. This needs a picture.....

 enter image description here

 As you can see, I have marked 3 squares - red, blue, and purple. Each of them is 2x2. The position at the bottom right, is the end of the 3x3 square. it is 1 + the minimum size of the blue, red, and purple squares.
 So, it becomes relatively simple to identify squares, we only need to check three values for each cell.... the code is surprisingly simple, even if the concept is hard...

 http://codereview.stackexchange.com/questions/88555/find-largest-block-in-matrix

 */
public class LargestSquare {



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] matrix = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };
        Square result = findLargestSquare(matrix);
        System.out.println(result.i+"  "+result.j+"  "+result.size);
    }

    private static Square findLargestSquare(int[][] matrix) {
        Square result=null;
        if(matrix==null || matrix.length==0)
            return null;
        int[] previous=null;
        int[] current=matrix[0];

        for(int i=1;i<matrix.length;i++){
            previous = current;
            current = new int[matrix[i].length];
            for(int j=0;j<matrix[i].length;j++){

                if(matrix[i][j]==1){
                    int span=1;
                    if(j>0){
                        span=1+Math.min(current[j-1],Math.min(previous[j-1],previous[j]));
                    }
                    if(result==null || span>result.size){
                        result = new Square(i-span+1,j-span+1,span);
                    }
                    current[j]=span;

                }
            }
        }

        return result;
    }

    public static class Square{

        int i;
        int j;
        int size;

        Square(int i,int j,int size){
            this.i = i;
            this.j = j;
            this.size = size;
        }

    }
}
