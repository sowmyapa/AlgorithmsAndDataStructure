package com.problem1.dp;//*********************************************************************************************************************************
// Name: Ronald Ogle
// Title: Assignment1.java
// Description: Computes tip for a restaurant bill when given the amount and tip percentage
// Time spent: 1 hour
// Date: 01/15/2017
//
// (a)The program has been named and the file should be saved the exact same way.
// (b)There were 3 syntax errors that occured didn't start output statement with quotations and didn't successfully begin literal.
// (c)Syntax error program doesn't know where to end the statement.
// (d)While running the code a syntax error occured at the end of the code because the class block wasnt closed.
// (e)The variable name was already declared must be consistent throughout the code.
//**********************************************************************************************************************************

/*1. (a)mystery has the value of 5. (b)mystery now has the value of 3. (c)mystery finally has a value of 4.
  2. (a)0 (b)3.3 (c)2 (d)4.3 (e)0.24806202 (f) */

import java.util.Scanner;
import java.text.NumberFormat;

public class Assignment1
{
	public static void main (String [] args)
	{
		double billAmount;
		double tip;
		double totalNew;
		int percent;  // variables declared

		Scanner scan = new Scanner(System.in);
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();  // allows the output to have a dollar sign and be in that format

		System.out.print("Enter the bill amount: ");  // prompt for user to enter his/her bill amount
		billAmount = scan.nextDouble();  // accept double variable from user and store it in billAmount

		System.out.print("What percent would you like to tip: ");  // prompt for the user to enter the percent theys want to tip
		percent = scan.nextInt();  // accept integer from user and store it in for percent

		tip = billAmount * (int)percent / 100; // computes tip amount based on percent entered by user
		totalNew = tip + billAmount;  // computes the new total after tip has been added

		System.out.println("Tip Amount: " + fmt1.format(tip));  // displays tip amount
		System.out.println("Total amount with tip: " + fmt1.format(totalNew));  // displays total price with tax included
	}
}






