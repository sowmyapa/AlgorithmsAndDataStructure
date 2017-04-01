package com.problem1;

import java.io.*;
import java.util.*;


/**
 * The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height. Each summer, its height increases by 1 meter.

 Laura plants a Utopian Tree sapling with a height of 1 meter at the onset of spring. How tall will her tree be after growth cycles?

 Input Format

 The first line contains an integer, , the number of test cases.
 subsequent lines each contain an integer, , denoting the number of cycles for that test case.

 Constraints


 Output Format

 For each test case, print the height of the Utopian Tree after  cycles. Each height must be printed on a new line.

 Sample Input

 3
 0
 1
 4
 Sample Output

 1
 2
 7
 Explanation

 There are 3 test cases.

 In the first case (), the initial height () of the tree remains unchanged.

 In the second case (), the tree doubles in height and is  meters tall after the spring cycle.

 In the third case (), the tree doubles its height in spring (), then grows a meter in summer (), then doubles after the next spring (), and grows another meter after summer (). Thus, at the end of 4 cycles, its height is  meters.
 */


public class UtopianTree {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        for(int i=0;i<testCases;i++){
            int n = Integer.parseInt(in.nextLine());
            height(n);
        }
    }

    static void height(int n){

        int height=1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                height*=2;
            }else{
                height+=1;
            }
        }
        System.out.println(height);
    }
}