package com.problem1.arrays;

import java.io.*;
import java.util.*;

/**
 *
 * https://www.hackerrank.com/challenges/sparse-arrays
 *
 * There are  strings. Each string's length is no more than  characters. There are also  queries. For each query, you are given a string, and you need to find out how many times this string occurred previously.

 Input Format

 The first line contains , the number of strings.
 The next  lines each contain a string.
 The nd line contains , the number of queries.
 The following  lines each contain a query string.

 Constraints





 Sample Input

 4
 aba
 baba
 aba
 xzxb
 3
 aba
 xzxb
 ab
 Sample Output

 2
 1
 0
 Explanation

 Here, "aba" occurs twice, in the first and third string. The string "xzxb" occurs once in the fourth string, and "ab" does not occur at all.
 */

public class SparseArrays {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String,Integer> data = new HashMap<String,Integer>();
        for(int i=0;i<n;i++){
            String input = in.nextLine();
            if(data.containsKey(input)){
                int value = data.get(input);
                data.put(input,++value);

            }else{
                data.put(input,1);
            }
        }
        int q = in.nextInt();
        in.nextLine();
        for(int i=0;i<q;i++){
            String query = in.nextLine();
            int answer = 0;
            if(data.containsKey(query)){
                answer = data.get(query);
                //System.out.println("answer"+answer+"query"+query);
            }
            System.out.println(answer);
        }
    }
}