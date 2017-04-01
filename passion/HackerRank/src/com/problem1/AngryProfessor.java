package com.problem1;

import java.io.*;
import java.util.*;

/**
 *
 *
 * A Discrete Mathematics professor has a class of  students. Frustrated with their lack of discipline, he decides to cancel class if fewer than  students are present when class starts.

 Given the arrival time of each student, determine if the class is canceled.

 Input Format

 The first line of input contains , the number of test cases.

 Each test case consists of two lines. The first line has two space-separated integers,  (students in the class) and (the cancelation threshold). The second line contains  space-separated integers () describing the arrival times for each student.

 Note: Non-positive arrival times () indicate the student arrived early or on time; positive arrival times () indicate the student arrived  minutes late.

 Constraints

 Output Format

 For each test case, print the word YES if the class is canceled or NO if it is not.

 Note
 If a student arrives exactly on time , the student is considered to have entered before the class started.

 Sample Input

 2
 4 3
 -1 -3 4 2
 4 2
 0 -1 2 1
 Sample Output

 YES
 NO
 Explanation

 For the first test case, . The professor wants at least  students in attendance, but only  have arrived on time ( and ). Thus, the class is canceled.

 For the second test case, . The professor wants at least  students in attendance, and there are  who have arrived on time ( and ). Thus, the class is not canceled.
 */
public class AngryProfessor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(in.nextLine());
        for(int i=0;i<numberOfTestCases;i++){
            String input = in.nextLine();
            String[] parsedInput = input.split(" ");
            input = in.nextLine();
            findOutClassStatus(Integer.parseInt(parsedInput[0]),Integer.parseInt(parsedInput[1]),input);

        }
    }

    static void findOutClassStatus(int n,int k,String input){
        String[] parsedInput = input.split(" ");
        int counter=0;
        for(String token: parsedInput){
            if(Integer.parseInt(token)<=0){
                counter++;
            }
            if(counter==k){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");



    }
}