package com.problem1;

public class MergeSort {
	
	public static void main(String[] args){
		int a[] = {5,7,8,0,-1,2};
		mergeSort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(" "+a[i]);
		}
	}

	private static void mergeSort(int[] a) {
		int length = a.length;

		if(length<2)
			return;
		int mid = length/2;
		int[] left = new int[mid];
		int[] right = new int[length-mid];
		for(int i=0;i<mid;i++){
			left[i] = a[i];
		}
		for(int i=mid;i<length;i++){
			right[i-mid] = a[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left,right,a);
	}

	private static void merge(int[] left, int[] right, int[] a) {
		int i=0,j=0,k=0;
		int leftLength = left.length;
		int rightLength = right.length;
		while(i<leftLength && j<rightLength){
			if(left[i]<=right[j]){
				a[k++]=left[i++];
			}else{
				a[k++]=right[j++];
			}
		}
		while(i<leftLength){
			a[k++]=left[i++];
		}
		while(j<rightLength){
			a[k++]=right[j++];
		}
	}

}
