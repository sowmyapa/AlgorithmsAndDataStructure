package com.problem1.arrays;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 10/23/17.
 */
public class RightRotation {

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

        for(int i=0;i<n;i++){
            output[(d+i)%n]=Integer.parseInt(values[i]);
        }
        for(int out : output){
            System.out.print(out+" ");
        }
    }

}
