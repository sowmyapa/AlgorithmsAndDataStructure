package com.problem1;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 2/26/17.
 */
public class StringPermutation {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        permutation(in.nextLine());
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

}
