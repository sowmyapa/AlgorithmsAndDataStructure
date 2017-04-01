package com.problem1.dp;

import java.util.Arrays;
 
public class Solution2 
{
   
    public void performSort(int[] inpArr) {
		createMaxHeap(inpArr);
		
		boolean isSortSuccessful = false;
		
		int inpArrLength = inpArr.length - 1;
		for (int index = inpArrLength; index > 0;){
			swapArrElements(inpArr, index, 0);
			heapify(inpArr, 0, --index);
		}
		isSortSuccessful = true;
	}

	protected void createMaxHeap(int[] inpArr) {
		int size = inpArr.length;
		int totalElements = inpArr.length - 1;
		int lastParent = totalElements / 2;
		for (int curNode = lastParent; curNode >= 0; curNode--) {
			heapify(inpArr, curNode, totalElements);
		}
	}

	protected void heapify(int[] inpArr, int curNode, int remElements) {
		int leftChildIndex = curNode * 2 + 1;
		int rightChildIndex = curNode * 2 + 2;
		// Leaf Node
		if (leftChildIndex > remElements) {
			return;
		}
		// Only left child exists
		else if (rightChildIndex > remElements) {
			if (inpArr[curNode] < inpArr[leftChildIndex]) {
				swapArrElements(inpArr, curNode, leftChildIndex);
			}
		}
		// both children exist
		else {
			int largerChildIndex = inpArr[leftChildIndex] > inpArr[rightChildIndex] ? 
					leftChildIndex : rightChildIndex;
			boolean swapReq = inpArr[curNode] > inpArr[largerChildIndex] ?
					false : true;
			if(swapReq){
				swapArrElements(inpArr, curNode, largerChildIndex);
				heapify(inpArr, largerChildIndex, remElements);
			}
		}
	}
	
	protected void swapArrElements(int[] inpArr, int x, int y){	
		int val = inpArr[x];
		inpArr[x] = inpArr[y];
		inpArr[y] = val;
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
    	int[] B = Arrays.copyOf(A, A.length);
    	int size = A.length;
    	performSort(B);
        
        int firstMisMatchIndex = -1;
        int lastMisMatchIndex = -1;
        boolean firstMisMatchFound = false;
        boolean lastMisMatchFound = false;
        
        int j = size - 1;
        int i = 0;
        for (i = 0; i < size; i++){
           
        	// Look for the mismatch from the beginning of the array
        	if(A[i] != B[i] && !firstMisMatchFound){
        		firstMisMatchIndex = i;
        		firstMisMatchFound = true;
        	}
        	
        	// Look for the mismatch from the end of the array
        	if(A[j] != B[j] && !lastMisMatchFound){
        		lastMisMatchIndex = j;
        		lastMisMatchFound = true;
        	}
        	j--;
        }
        
        // Return the difference.
        int res = lastMisMatchIndex - firstMisMatchIndex + 1;
        
        return (res == 1)? 0 : res;
    }
    
    public static void main(String[] args){
    	Solution2 s = new Solution2();
    	
    	int[] a1 = new int[]{1,2,3};
    	
    	s.method(a1);
    	
    	System.out.println("Solution.main() "+a1[0]+" "+a1[1]+" "+a1[2]);
    	
    	
    	System.out.println("Solution.main() "+a1[0]+" "+a1[1]+" "+a1[2]);
    }
    
    public void method(int[] a){
    	a[1] = 7;
    }
    
}