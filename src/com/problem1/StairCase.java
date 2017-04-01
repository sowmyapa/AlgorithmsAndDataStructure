package com.problem1;

import java.util.Scanner;

public class StairCase {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
        
        StairCase(_n);
        
	}
	
	 static void StairCase(int n) {
		 for(int i=0;i<n;i++){
			 StringBuilder output=new StringBuilder();

			 for(int j=1;j<n-i;j++){
				 output=output.append(" ");
			 }
			 for(int j=0;j<=i;j++){
				 output=output.append("#");
			 }
			 
	       System.out.println(output);
		 }

	 }



}
