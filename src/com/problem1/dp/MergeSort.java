package com.problem1.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	
	public static void main(String[] args){
		MergeSort ms = new MergeSort();
		
		System.out.println("Enter size :");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		System.out.println("Enter Numbers :");
		for(int i = 0; i < size; i++){
			arr[i] = sc.nextInt();
		}
		
		ms.sort(arr);
		
		for(int i = 0; i < size; i++){
			System.out.println(" "+ arr[i]);
		}
		
	}
		
	private void sort(int[] arr){
		arr = merge(arr.length, arr);
	}
	
	private int[] merge(int n, int[] arr){
		
		if(n == 1){
			return arr;
		}
		
		int[] leftArr = null;
		int[] rightArr = null;
		
		int midPoint = n/2;
		leftArr = Arrays.copyOfRange(arr, 0, midPoint);
		rightArr = Arrays.copyOfRange(arr, midPoint, n);
		
		leftArr = merge(leftArr.length, leftArr);
		rightArr = merge(rightArr.length, rightArr);
		
		int i = 0, j = 0, k = 0;
		for(k = 0; k < n && i < leftArr.length && j < rightArr.length;){
			if(leftArr[i] <= rightArr[j]){
				arr[k] = leftArr[i];
				i++;
			}
			else{
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i < leftArr.length){
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while(j < rightArr.length){
			arr[k] = rightArr[j];
			j++;
			k++;
		}
		
		return arr;
	}
}
