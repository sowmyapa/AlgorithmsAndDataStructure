package com.problem1.machinezone;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 10/23/17.
 */
public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numberOfSticks = in.nextInt();
        in.nextLine();
        int[] sticks = new int[numberOfSticks];
        for(int i = 0; i< sticks.length;i++){
            sticks[i] = in.nextInt();
        }
        Arrays.sort(sticks);
        for(int i = sticks.length-1;i>=2;i--){
            if(sticks[i]<sticks[i-1]+sticks[i-2]){
                System.out.println(sticks[i-2]+" "+sticks[i-1]+" "+sticks[i]);
                return;
            }
        }
        System.out.println("-1");
    }

}
