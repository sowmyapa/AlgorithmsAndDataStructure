package com.problem1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Two strings  and  are called anagrams if they consist same characters, but may be in different orders. So the list of anagrams of  is .

Given two strings, print Anagrams if they are anagrams, print Not Anagrams if they are not. The strings may consist at most  English characters; the comparison should NOT be case sensitive.

This exercise will verify that you can sort the characters of a string, or compare frequencies of characters.
 * @author sowmyaparameshwara
 *
 */
public class anagrams {
	
	 public static void main(String[] args) {
		    
	        Scanner scan = new Scanner(System.in);
	        String a = scan.next();
	        String b = scan.next();
	        scan.close();
	        boolean ret = isAnagram(a, b);
	        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	    }
	 
	    static boolean isAnagram(String a, String b) {
	    	boolean result = true;
	    	if(a.length()!=b.length()){
	    		return false;
	    	}
	    	char[] aArray = a.toLowerCase().toCharArray();
	    	char[] bArray = b.toLowerCase().toCharArray();

	        
	       Arrays.sort(aArray);
	       Arrays.sort(bArray);
	       for(int i=0 ; i<aArray.length ; i++){
	    	   if(aArray[i]!=bArray[i]){
	    		   return false;
	    	   }
	       }
	       return result;
	        
	    }

}
