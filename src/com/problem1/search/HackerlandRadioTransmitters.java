package com.problem1.search;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
 */
public class HackerlandRadioTransmitters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        Arrays.sort(x);
        int numberOfTransmitters=0;
        int i=0;
        while(i<n){
            numberOfTransmitters++;
            /* Key is to use greedy algorithm to always place the transmitter at the house furthest to the right possible
	 * to cover the range.
	 */
            int loc = x[i]+k;//let this i be i_orig
            //go to right as far as we cover i_orig as well.
            while(i<n && x[i]<=loc){
                i++;
            }
            // this is where we place the transmitter at x[i-1]
            loc = x[i-1]+k;
            //now go to the right of x[i] by k because transmitter at x[i] covers houses to its right as well.
            while(i<n && x[i]<=loc){
                i++;
            }
        }
        System.out.println(numberOfTransmitters);
    }
}