package com.problem1.dp;

import java.util.Arrays;
 
public class Solution1 
{
   
    private void sort(int[] A) {
		generateHeap(A);
		int aLen = A.length - 1;
		for (int p = aLen; p > 0;){
			swap(A, p, 0);
			heapify(A, 0, --p);
		}
	}

	private void generateHeap(int[] A) {
		int count = A.length - 1;
		int prevParent = count / 2;
		for (int iNode = prevParent; iNode >= 0; iNode--) {
			heapify(A, iNode, count);
		}
	}

	private void heapify(int[] A, int iNode, int balanceNodes) {
		int lChld = iNode * 2 + 1;
		int rChld = iNode * 2 + 2;
		// Leaf Node
		if (lChld > balanceNodes) {
			return;
		}
		// Only left child exists
		else if (rChld > balanceNodes) {
			if (A[iNode] < A[lChld]) {
				swap(A, iNode, lChld);
			}
		}
		// both children exist
		else {
			int largerNode = A[lChld] > A[rChld] ? 
					lChld : rChld;
			boolean swapReq = A[iNode] > A[largerNode] ?
					false : true;
			if(swapReq){
				swap(A, iNode, largerNode);
				heapify(A, largerNode, balanceNodes);
			}
		}
	}
	
	private void swap(int[] A, int a, int b){	
		int val = A[a];
		A[a] = A[b];
		A[b] = val;
	}

    /**
     * The idea here is to sort the arrays using merge sort which has nlogn complexity and then comparing
     * the sorted array with the original array to identify the indexes where mismatch starts from both edges of the 
     * array. The difference between these indexes is the required result.
     * 
     * @param A
     * @return
     */
    public int solution(int[] A){
    	// Since we are taking a copy of the original array(O(N) space), and heap sort takes(O(1)) space
    	// to sort the array, overall space complexity of the problem is within O(N).
    	
    //	int size = A.length;
    	
    	int[] resArr = Arrays.copyOf(A, A.length);
    	
    	sort(resArr);
        
        int res1 = -1;
        int res2 = -1;
        
        int res = 0;
        
        boolean forwardMisMatchNotFound = true;
        boolean backwardMismatchNotFound = true;
        
        int backwardIterator = A.length - 1;
        int forwardIterator = 0;
        for (forwardIterator = 0; forwardIterator < A.length; forwardIterator++){
           
        	if(A[forwardIterator] != resArr[forwardIterator] && forwardMisMatchNotFound){
        		res1 = forwardIterator;
        		forwardMisMatchNotFound = false;
        	}
        	
        	if(A[backwardIterator] != resArr[backwardIterator] && backwardMismatchNotFound){
        		res2 = backwardIterator;
        		backwardMismatchNotFound = false;
        	}
        	backwardIterator--;
        }
        
        res = res2 - res1 + 1;
        
        return (res == 1)? 0 : res;
    }
    
    public static void main(String[] args){
    	Solution2 s = new Solution2();
    	
    	int[] a1 = new int[]{1,6,2,5,5,8,9};
    	
    	int res = s.solution(a1);
    	
    	System.out.println("Solution1.main() res "+res);
    	
    }
    
}