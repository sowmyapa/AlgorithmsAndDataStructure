package com.problem1.sorting;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/big-sorting
 */
public class BigSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        CustomSort customSort = new CustomSort();
        Arrays.sort(unsorted,customSort);
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            System.out.println(unsorted[unsorted_i]);
        }
    }

    static class CustomSort implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if(o1.length()==o2.length()){
                return o1.compareTo(o2);
            }
            return new Integer(o1.length()).compareTo(new Integer(o2.length()));
        }
    }
}