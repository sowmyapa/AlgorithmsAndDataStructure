package com.problem1.arrays;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/13/17.
 * http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 */
public class TripletInArray {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] input = new int[n];
        for(int i=0; i <n;i++){
            input[i] = in.nextInt();
        }
        in.nextLine();
        int toBeCompared = in.nextInt();
        TripletInArray tripletInArray = new TripletInArray();
        tripletInArray.findTripletWhichSumTo(input,toBeCompared);
    }

    private void findTripletWhichSumTo(int[] input, int toBeCompared) {
        for(int i=0;i<input.length-2;i++){
             int x = input[i];
            int l=i+1;
            int r=input.length-1;
            while(l<r){
                int value = x+input[l]+input[r];
                if(value==toBeCompared){
                    System.out.println("Triplet found : "+x+" "+input[l]+" "+input[r]);
                    return;
                }else if(value<toBeCompared){
                    l++;
                }else{
                    r++;
                }

            }

        }
    }
}
