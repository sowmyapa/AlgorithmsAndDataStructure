package com.problem1;

/**
 *
 * Time complexity of entire algorithm is 0(nlogn).
 * Building heap takes : O(n)
 * Extracting minimum from heap takes O(logn) and this operation run n-1 times.
 */
public class Heapsort {
	
	public static void main(String[] args){
		int[] a = {2,0,-2,-1,5,7,8};
		heapsort(a);
		for(int val : a ){
			System.out.println(val);
		}
	}

	private static void heapsort(int[] a) {
		maxHeapify(a);
		int heapsize=a.length-1;
		for(int i=a.length;i>=1;i--){
			int temp=a[0];
			a[0]=a[heapsize];
			a[heapsize]= temp;
			heapsize--;
			heapify(a,0,heapsize);
			
		}
		
	}

	private static void maxHeapify(int[] a) {
		for(int i =a.length/2;i>=0;i--){
			heapify(a,i,a.length-1);
		}
		
	}

	private static void heapify(int[] a, int i,int heapsize) {
		int max = i;
		int l=2*i;
		int r=2*i+1;
		if(l<=heapsize && a[l]>a[max])
			max=l;
		if(r<=heapsize && a[r]>a[max])
			max=r;
		if(max!=i){
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
			heapify(a,max,heapsize);
		}
		
	}

}
