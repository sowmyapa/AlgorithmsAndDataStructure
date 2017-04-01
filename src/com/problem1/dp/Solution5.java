package com.problem1.dp;

import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args){
		
		
		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int length = input.length();
		
		double rootLength = Math.sqrt(length);
		int floor = (int)Math.floor(rootLength);
		int ceiling = (int)Math.ceil(rootLength);
		
		int prod = floor * ceiling;
		if(prod < length){
			floor++;
		}
		
		//System.out.println("Solution.main() rootLength "+rootLength);
		//System.out.println("Solution.main() floor "+floor);
		//System.out.println("Solution.main() ceiling "+ceiling);
		
		int pos = 0;
		for(int i = 0; i < ceiling; i++){
			for(int j = 0; j < floor; j++){
				pos = j * ceiling + i;
				if(pos < input.length()){
					System.out.print(input.charAt(pos));	
				}
				
			}
			System.out.print(" ");
		}
	}
}
