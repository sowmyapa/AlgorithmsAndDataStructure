package com.problem1.interviewcake;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by sowmyaparameshwara on 4/3/17.
 */
public class HighestProductOfThree {


    public static void main(String[] args){
        System.out.println("Enter the number of inputs");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] input = new int[n];
        for(int i=0; i<n ;i++){
            input[i] = in.nextInt();
        }
        findHighestProductOfThree(input);
    }

    private static void findHighestProductOfThree(int[] input) {
        if(input.length<3){
            throw new IllegalArgumentException("Atleast 3 numbers are needed ");
        }
        int highest = Math.max(input[0],input[1]);
        int lowest = Math.min(input[0],input[1]);
        int highestProductOfTwo = input[0]*input[1];
        int lowestProductOfTwo = input[0]*input[1];

        int highestProductOf3 = input[0]*input[1]*input[2];
        for(int i=2;i<input.length;i++){
            int current = input[i];
            highestProductOf3 = Math.max(Math.max(current*highestProductOfTwo,current*lowestProductOfTwo),highestProductOf3);
            highestProductOfTwo = Math.max(Math.max(current*highest,highestProductOfTwo),current*lowest);
            lowestProductOfTwo = Math.min(Math.min(current*lowest,lowestProductOfTwo),current*highest);

            highest = Math.max(current,highest);
            lowest = Math.min(current,lowest);

        }
        System.out.println("Highest Product : "+highestProductOf3);
    }
}
