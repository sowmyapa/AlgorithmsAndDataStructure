package com.problem1.arrays;

import java.util.Arrays;

/**
 * Created by sowmyaparameshwara on 4/3/17.
 */
public class LongestIncreasingPath {

    public static void main(String[] args){
        int[][]  mat = {{1, 2, 9},
            {5, 3, 8},
            {4, 6, 7}};
            detemineLongestIncreasingPath(mat);

    }

    private static void detemineLongestIncreasingPath(int[][] mat) {
        int[][] perCellPath = new int[mat.length][mat.length];
        int[] path=new int[mat.length*mat.length];
        Arrays.fill(path, -1);
        for(int i=0;i<perCellPath.length;i++) {
            Arrays.fill(perCellPath[i], -1);
        }
        int result=0;
        int maxIndex=-1;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                determineLongestIncreasingPathPerCell(i,j,mat,perCellPath,path);
                if(result<perCellPath[i][j]){
                    result = perCellPath[i][j];
                    maxIndex=i*mat.length + j;
                }
            }
        }
        System.out.println(Math.max(result,0));
        printPath(path,maxIndex,mat);
    }

    private static void printPath(int[] path, int maxIndex,int[][] mat) {
        if(path[maxIndex]!=-1){
            printPath(path,path[maxIndex],mat);
        }
        System.out.println("==>"+mat[maxIndex/mat.length][maxIndex%mat.length]);
    }

    private static int determineLongestIncreasingPathPerCell(int row,int col, int[][] mat, int[][] perCellPath,int[] path) {
        if(perCellPath[row][col]!=-1)
            return perCellPath[row][col];
        if(row<mat.length-1 && (mat[row][col]+1==mat[row+1][col])) {
            int subPath = determineLongestIncreasingPathPerCell(row + 1, col, mat, perCellPath, path);
            if(path[(row*mat.length)+col]==-1){
                path[(row*mat.length)+col]=((row+1)*mat.length)+col;
            }else{
                int parentRow=path[(row*mat.length)+col]%mat.length;
                int parentCol=path[(row*mat.length)+col]-(parentRow*mat.length);
                path[(row*mat.length)+col]=perCellPath[parentRow][parentCol]>subPath?path[(row*mat.length)+col]:((row+1)*mat.length+col);
            }
            return perCellPath[row][col] = 1 + subPath;
        }
        if(row>0 && (mat[row][col]+1==mat[row-1][col])) {
            int subPath = determineLongestIncreasingPathPerCell(row - 1, col, mat, perCellPath, path);
            if(path[(row*mat.length)+col]==-1){
                path[(row*mat.length)+col]=((row-1)*mat.length)+col;
            }else{
                int parentRow=path[(row*mat.length)+col]%mat.length;
                int parentCol=path[(row*mat.length)+col]-(parentRow*mat.length);
                path[(row*mat.length)+col]=perCellPath[parentRow][parentCol]>subPath?path[(row*mat.length)+col]:((row-1)*mat.length+col);
            }
            return perCellPath[row][col] = 1 + subPath;
        }
        if(col>0 && (mat[row][col]+1==mat[row][col-1])) {
            int subPath = determineLongestIncreasingPathPerCell(row , col-1, mat, perCellPath, path);
            if(path[(row*mat.length)+col]==-1){
                path[(row*mat.length)+col]=((row)*mat.length)+(col-1);
            }else{
                int parentRow=path[(row*mat.length)+col]%mat.length;
                int parentCol=path[(row*mat.length)+col]-(parentRow*mat.length);
                path[(row*mat.length)+col]=perCellPath[parentRow][parentCol]>subPath?path[(row*mat.length)+col]:((row)*mat.length+(col-1));
            }
            return perCellPath[row][col] = 1 + subPath;
        }
        if(col<mat.length-1 && (mat[row][col]+1==mat[row][col+1])) {
            int subPath = determineLongestIncreasingPathPerCell(row , col+1, mat, perCellPath, path);
            if(path[(row*mat.length)+col]==-1){
                path[(row*mat.length)+col]=((row)*mat.length)+(col+1);
            }else{
                int parentRow=path[(row*mat.length)+col]%mat.length;
                int parentCol=path[(row*mat.length)+col]-(parentRow*mat.length);
                path[(row*mat.length)+col]=perCellPath[parentRow][parentCol]>subPath?path[(row*mat.length)+col]:((row)*mat.length+(col+1));
            }
            return perCellPath[row][col] = 1 + subPath;
        }
        return perCellPath[row][col]=1;
    }
}
