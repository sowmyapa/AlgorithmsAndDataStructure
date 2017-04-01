package com.problem1.arrays;

import java.io.*;
import java.util.*;

/**
 *
 * https://www.hackerrank.com/challenges/dynamic-array
 *
 * Create a list, , of  empty sequences, where each sequence is indexed from  to . The elements within each of the  sequences also use -indexing.
 Create an integer, , and initialize it to .
 The  types of queries that can be performed on your list of sequences () are described below:
 Query: 1 x y
 Find the sequence, , at index  in .
 Append integer  to sequence .
 Query: 2 x y
 Find the sequence, , at index  in .
 Find the value of element  in  (where  is the size of ) and assign it to .
 Print the new value of  on a new line
 Task
 Given , , and  queries, execute each query.

 Note:  is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia.

 Input Format

 The first line contains two space-separated integers,  (the number of sequences) and  (the number of queries), respectively.
 Each of the  subsequent lines contains a query in the format defined above.

 Constraints

 It is guaranteed that query type  will never query an empty sequence or index.
 Output Format

 For each type  query, print the updated value of  on a new line.

 Sample Input

 2 5
 1 0 5
 1 1 7
 1 0 3
 2 1 0
 2 1 1
 Sample Output

 7
 3
 Explanation

 Initial Values:




 Query 0: Append  to sequence .



 Query 1: Append  to sequence .


 Query 2: Append  to sequence .



 Query 3: Assign the value at index  of sequence  to , print .


 7
 Query 4: Assign the value at index  of sequence  to , print .


 3
 */
public class DynamicArrays {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q =  in.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();

        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<Integer>());
        }
        int lastAns=0;

        for(int i=0;i < q;i++){
            int queryType =  in.nextInt();
            int x =  in.nextInt();
            int index =  in.nextInt();
            if(queryType==1){
                int sequenceIndex=(x^lastAns)%n;
                List<Integer> seqList= map.get(sequenceIndex);
                seqList.add(index);
            }else if(queryType==2){
                int sequenceIndex=(x^lastAns)%n;
                List<Integer> seqList= map.get(sequenceIndex);
                int value = seqList.get(index%seqList.size());
                lastAns=value;
                System.out.println(lastAns);
            }
        }

    }

}