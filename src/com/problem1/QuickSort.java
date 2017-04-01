package com.problem1;

public class QuickSort {
	
	public static void main(String[] args){
		int a[] = {5,7,8,0,-1,2};
		quicksort(a,0,a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.print(" "+a[i]);
		}
	}

	private static void quicksort(int[] a, int start, int end) {
		if(start<end){
			int pIndex = partition(a,start,end);
			quicksort(a,start,pIndex-1);
			quicksort(a,pIndex+1,end);
		}
		
	}

	private static int partition(int[] a, int start, int end) {
		int pIndex=start;
		int pivot = a[end];
		for(int i=start;i<=end;i++){
			if(a[i]<pivot){
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		int temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}


}
