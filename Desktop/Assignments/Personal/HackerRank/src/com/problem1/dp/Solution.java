package com.problem1.dp;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(in.nextLine());

		String inputLine;
		String[] sidesAsStr;
		int[] sides;
		for (int i = 0; i < noOfTestCases; i++) {
			inputLine = in.nextLine();
			sidesAsStr = inputLine.split(" ");
			sides = new int[3];
			sides[0] = Integer.parseInt(sidesAsStr[0]);
			sides[1] = Integer.parseInt(sidesAsStr[1]);
			sides[2] = Integer.parseInt(sidesAsStr[2]);

			System.out.println(getTypeOfTriangle(sides));
		}

		// Avoiding resource leakage
		in.close();
	}

	private static String getTypeOfTriangle(int[] sides) {
		if (isValidTriangle(sides)) {
			// Unnecessary to have the third equivalence check, obviously!
			if (sides[0] == sides[1] && sides[0] == sides[2]) {
				return "Equilateral";
			}
			if (sides[0] == sides[1] || sides[0] == sides[2] || sides[1] == sides[2]) {
				return "Isosceles";
			}
			return "None of these";
		}
		return "None of these";
	}

	/**
	 * For a triangle to be valid, it is necessary that the sum of any two sides
	 * be greater than the third
	 * 
	 * @param sides
	 * @return
	 */
	private static boolean isValidTriangle(int[] sides) {
		if (sides[0] < sides[1] + sides[2] && sides[1] < sides[2] + sides[0] && sides[2] < sides[0] + sides[1]) {

			return true;
		}
		return false;
	}
}
