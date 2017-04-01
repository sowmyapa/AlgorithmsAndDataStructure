package com.problem1.arrays;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 3/9/17.
 */
public class DuplicateElement {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] input = new int[n];
        int sum=0;
        int sumOfSquares=0;
        for(int i=0; i<n ;i++){
            input[i] = in.nextInt();
            sum+=input[i];
            sumOfSquares+=(input[i]*input[i]);
        }
        int a = sum-(n*(n-1)/2);
        int b = (sumOfSquares-(n*(n-1)*(2*n-1)/6))/a;
        System.out.println("Number duplicate : "+(a+b)/2);
        System.out.println("Number removed : "+(b-a)/2);


    }

}
