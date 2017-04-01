package com.problem1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Platform {
	
	public static void main(String[] args) throws IOException{
	       Scanner in = new Scanner(System.in);
	       int arr[] = {900, 940, 950, 1100, 1500, 1800};
		    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	       
	       int res = findMinGates(arr, dep, 0);
	      
	   }

	private static int findMinGates(int[] _arrivals, int[] _departures, int _flights) {
		  /* int arr[] = {900, 940, 950, 1100, 1500, 1800};
		    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};*/
		    
		    int arr[] = {900, 902, 904, 906, 908, 910};
		    int dep[] = {902, 904, 906, 908, 910,912};
		    Arrays.sort(arr);
		    Arrays.sort(dep);
		    int number_of_platforms=0;
		    int result=1;
		    int i=0,j=0;
		    while(i<arr.length && j<arr.length){
		    	if(arr[i]<=dep[j]){
		    		number_of_platforms++;
		    		if(number_of_platforms>result){
		    			result = number_of_platforms;
		    		}
		    		i++;
		    	}else{
		    		number_of_platforms--;
		    		j++;
		    	}
		    }
		    if(i<arr.length){
		    	number_of_platforms++;
	    		if(number_of_platforms>result){
	    			result = number_of_platforms;
	    		}
		    }
		    System.out.print(result);
		return result;
	}
	

}
