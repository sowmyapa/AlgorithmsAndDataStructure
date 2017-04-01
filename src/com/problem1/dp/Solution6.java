package com.problem1.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution6 {

	/*
	 * 1234 1243 1324 1342 1423 1432 2134 2143 2314 2341 2413 2431 3124 3142
	 * 3214 3241 3412 3421 4123 4132 4213 4231 4312 4321
	 */

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int counter = in.nextInt();
		String inpArr[] = new String[counter];
		for (int i = 0; i < counter; i++) {
			inpArr[i] = in.next();
		}
		String input;
		for (int i = 0; i < counter; i++) {
			input = inpArr[i];
			int[] charArr = new int[input.length()];
			for (int j = 0; j < input.length(); j++) {
				charArr[j] = (int) input.charAt(j);
			}
			int k = 0;
			int key = -1;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (k = charArr.length - 1; k > 0; k--) {
				if (charArr[k] > charArr[k - 1]) {
					list.add(charArr[k]);
					list.add(charArr[k - 1]);
					key = charArr[k - 1];
					break;
				} else {
					list.add(charArr[k]);
				}
			}
			if (k == 0) {
				System.out.println("no answer");
				continue;
			}
			k--;

			//ArrayList<Integer> sortedList = (ArrayList<Integer>) list.clone();
			Collections.sort(list);

			ArrayList<Integer> result = new ArrayList<Integer>();

			for (int l = 0; l < k; l++) {
				result.add(charArr[l]);
			}

			int index = list.indexOf(key) + 1;
			result.add(list.get(index));
			list.remove(index);

			for (int l = 0; l < list.size(); l++) {
				result.add(list.get(l));
			}

			for (int l = 0; l < result.size(); l++) {
				int val = result.get(l);
				System.out.print((char) val);
			}
			System.out.print("\n");

		}

	}

}
