package com.problem1.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int[] A = new int[]{4,4,2,4,4,2,4};
		int res = s.solution(A);
		System.out.println("Solution.main() res "+res);
		
	/*	int res = s.solution(18, 195378678);
		System.out.println("Solution.main() res "+res);
	*/	
		
		/*int[] A = new int[]{1,1,0,1,0,0};
		int res = s.solution(A);
		System.out.println("Solution.main() res "+res);
		*/
	}

	int solution(int[] A) {
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++){
            for (int j = i; j < N; j++){
                if (A[i] != A[j]){
                    result = Math.max(result, j - i);
                }    
            }
            System.out.println("Solution.solution() count : "+i);
            System.out.println("Solution.solution() result : "+result);
        }    
        return result;
    }

	
	/*public int solution(int A, int B){
		String src = Integer.toString(B);
		String subString = Integer.toString(A);
		return src.indexOf(subString);
	}*/
	
	
		// 0,0,0,0,0,1
	    /*int solution(int[] A) {
	    	A = new int[]{0,1};
	        int n = A.length;
	        int result = 0;
	        for (int i = 0; i < n - 1; i++) {
	            if (A[i] == A[i + 1])
	                result = result + 1;
	        }
	        System.out.println("Solution.solution() result "+result);
	        int r = 0;
	        for (int i = 0; i < n; i++) {
	            int count = 0;
	            if (i > 0) {
	                if (A[i - 1] != A[i])
	                    count = count + 1;
	                else
	                    count = count - 1;
	            }
	            if (i < n - 1) {
	                if (A[i + 1] != A[i])
	                    count = count + 1;
	                else
	                    count = count - 1;
	            }
	            System.out.println("Solution.solution() i : "+i);
	            System.out.println("Solution.solution() count : "+count);
	            System.out.println("Solution.solution() r : "+r);
	            r = Math.max(r, count);
	            System.out.println("Solution.solution() after r : "+r);
	        }
	        if(r==0 && A.length > 1){
	        	return result - 1;
	        }
	        return result + r;
	    }*/
}
