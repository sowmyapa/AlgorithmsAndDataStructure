package com.problem1.dp;/*-------------------------------------------------------------------------------------------------
// AUTHOR: Ronald Ogle
// FILENAME: Lab2.java
// SPECIFICATION: This program will ask for three test scores and then average them together.
// FOR: CSE 110- Lab #2
// TIME SPENT: 45 min
//----------------------------------------------------------------------------*/

import java.util.Scanner;

public class Lab2
{
	public static void main (String[] args)
	{
		final int NUM_TESTS = 3;    // the total number of tests taken
		int test1;
		int test2;
		int test3;

		Scanner in = new Scanner(System.in);


		System.out.print("Enter the score on the first test: ");   // prompt
		test1 = in.nextInt();   // read in the next integer (since test1 is an int) and store it in test1

		System.out.print("Enter the score on the second test: ");   // prompt
		test2 = in.nextInt();   // read in the next integer (since test2 is an int) and store it in test2

		System.out.print("Enter the score on the third test: ");   // prompt
		test3 = in.nextInt();   // read in the next integer (since test3 is an int) and store it in test3



		double average = (test1 + test2 + test3) / (double)NUM_TESTS;    //compute the average for the three tests

		System.out.println("Your average score is: " + average);   // prints average of tests
		}
}


