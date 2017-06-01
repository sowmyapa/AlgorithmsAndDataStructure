package com.problem1.arrays;

import java.io.*;
import java.util.*;

/**
 *
 * https://www.hackerrank.com/challenges/crush
 *
 *
 *
 * You are given a list of size , initialized with zeroes. You have to perform  operations on the list and output the maximum of final values of all the  elements in the list.
 * For every operation, you are given three integers ,  and  and you have to add value  to all the elements ranging from index  to (both inclusive).

 Input Format

 First line will contain two integers  and  separated by a single space.
 Next  lines will contain three integers ,  and  separated by a single space.
 Numbers in list are numbered from  to .

 Constraints






 Output Format

 A single line containing maximum value in the updated list.

 Sample Input

 5 3
 1 2 100
 2 5 100
 3 4 100
 Sample Output

 200
 Explanation

 After first update list will be 100 100 0 0 0.
 After second update list will be 100 200 100 100 100.
 After third update list will be 100 200 200 200 100.
 So the required answer will be 200.



 Instead of storing the actual values in the array, you store the difference between the current element and the previous element.
 So you add sum to a[p] showing that a[p] is greater than its previous element by sum.
 You subtract sum from a[q+1] to show that a[q+1] is less than a[q] by sum (since a[q] was the last element that was added to sum).
 By the end of all this, you have an array that shows the difference between every successive element.
 By adding all the positive differences, you get the value of the maximum element
 */
public class AlgorithmicCrush {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] input = new long[n];
        long x =0;
        in.nextLine();
        long max=0;
        for(int i=0;i<m;i++){
            int startIndex = in.nextInt();
            int endIndex=in.nextInt();
            startIndex--;
            int value = in.nextInt();
            input[startIndex]+=value;
            if(endIndex<n){
                input[endIndex]-=value;
            }
        }
        for(int i=0;i<n;i++){
            x=x+input[i];
            if(max<x){
                max=x;
            }

        }
        System.out.println(max);
    }
}