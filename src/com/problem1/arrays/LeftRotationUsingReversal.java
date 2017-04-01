package com.problem1.arrays;

import java.io.*;
import java.util.*;

public class LeftRotationUsingReversal {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] values = input.split(" ");
        int n = Integer.parseInt(values[0]);
        int d = Integer.parseInt(values[1]);
        input = in.nextLine();
        values = input.split(" ");
        int[] output =new int[n];
        for(int i=0;i<n ;i++){
            output[i] = Integer.parseInt(values[i]);
        }
        rotate(output,n,d);
        for(int out : output){
            System.out.print(out+" ");
        }
    }

    static void rotate(int[] output,int n, int d){
        reverse(output,0,d-1);
        reverse(output,d,n-1);
        reverse(output,0,n-1);
    }

    static void reverse(int[] output, int start, int end){
        int i=start;
        int j=end;

        while(i<j){
            int temp=output[i];
            output[i]=output[j];
            output[j]=temp;
            i++;
            j--;
        }
    }
}