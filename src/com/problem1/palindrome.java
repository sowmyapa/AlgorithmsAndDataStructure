package com.problem1;

import java.util.Scanner;

/**
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.(Wikipedia)
Given a string , print Yes if it is a palindrome, print No otherwise.

Constraints

 will consist at most  lower case english letters.
Sample Input

madam
Sample Output

Yes
 * @author sowmyaparameshwara
 *
 */
public class palindrome {
	
	 public static void main(String[] args) {
	        
	        Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        int length = A.length();
	        String result="Yes";
	        for(int i=0; i<length/2;i++){
	        	if(A.charAt(i)!=A.charAt(length-i-1)){
	        		result="No";
	        		break;
	        	}
	        }
	        System.out.println(result);
	        
	    }

}
