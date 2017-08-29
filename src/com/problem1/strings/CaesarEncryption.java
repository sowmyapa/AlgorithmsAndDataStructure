package com.problem1.strings;

import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 */
public class CaesarEncryption {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String input = in.nextLine();
        int k=in.nextInt();
        k = k%26;
        char[] result = input.toCharArray();
        for(int i=0;i<n;i++){
            char c = input.charAt(i);
            if(c>='a' && c<='z'){
                result[i] = (char) ('a'+(c-'a'+k)%26);
            }else if(c>='A' && c<='Z'){
                result[i] = (char) ('A'+(c-'A'+k)%26);
            }
        }
        System.out.println(result);
    }
}
