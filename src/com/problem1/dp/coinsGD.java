package com.problem1.dp;

import java.util.Scanner;

public class coinsGD 
{

	public static void main(String args[]) 
	{
	int[] coins = new int[3];
	Scanner scan = new Scanner(System.in);
	
	for(int j =0;j<coins.length;j++)
	{
		coins[j]=scan.nextInt();
		int a = coins[j];
		int k = (int)(-1+Math.sqrt(1+8*a))/2;
		System.out.println(k);
		
	}		
	}
	
}
