package com.problem1.dp;

import java.io.*;
import java.util.*;

public class Hiya {
	static List<Integer> s = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		int N = 4;

		int[] a = { 2, 2, 0, 2 };
		jump(a, N);
		for (int i : s)
			System.out.print(i + ",");
		System.out.println("out");
	}

	public static int jump(int A[], int n) {

		s.add(0);

		int maxPosition = A[0];
		int curMaxPosition = A[0];
		int curStep = 1;
		for (int i = 1; i <= maxPosition; i++) {
			if (i == n - 1) {
				return curStep;
			}
			if (A[i] == 0) {
				continue;
			}
			curMaxPosition = Math.max(curMaxPosition, i + A[i]);

			if (i == maxPosition) {
				if (curMaxPosition <= i)
					return -1;
				maxPosition = curMaxPosition;
				s.add(maxPosition);
				curStep++;
			}

		}

		return -1;
	}
}