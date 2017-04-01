package com.problem1;

import java.util.Scanner;

public class PrimeNumbers {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		prime(input);
	}

	private static void prime(int input) {
		boolean[] values = new boolean[input];
		for(int i=2;i<input;i++){
			values[i]=true;
		}
		for(int i=2;i*i<input;i++){
			if(!values[i])
				continue;
			for(int j=i*2;j<input;j+=i){
				values[j] = false;
			}
		}
		for(int i=2;i<input;i++){
			if(values[i])
				System.out.print(" "+i);
		}
		
	}

}
