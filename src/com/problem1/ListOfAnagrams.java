package com.problem1;

import java.util.Arrays;
import java.util.Scanner;

public class ListOfAnagrams {


	public static void main(String[]args){
	  System.out.println("enter number of strings:");
	  ListOfAnagrams l = new ListOfAnagrams();
	  l.process();
	  
	  
	}
	
	public void process(){
		  Scanner input = new Scanner(System.in);

		 int count = input.nextInt();
		  String[] original = new String[count];
		  for(int i=0;i<count;i++){
			  original[i] = input.next();
		  }
		  
		  Word[] copy = new Word[count];
		  for(int i=0;i<count;i++){
			  char[] sorted = original[i].toCharArray();
			  Arrays.sort(sorted);
			  copy[i] = new Word(new String(sorted),i);
		  }
		  mergeSort(copy);
		  System.out.println("output");
		  for(int i=0;i<count;i++){
			  System.out.println(" "+original[copy[i].index]);
		  }
	}
	
	/**
	 * Merge ssort nlogn worst case complexity o(n) space complexity , not an inplace algorithm
	 * Quick sort nlogn average case, n^2 worst case, in place. 
	 * @param a
	 */
	
	    public static void mergeSort(Word [ ] a)
		{
	    	Word[] tmp = new Word[a.length];
			mergeSort(a, tmp,  0,  a.length - 1);
		}


		private static void mergeSort(Word [ ] a, Word [ ] tmp, int left, int right)
		{
			if( left < right )
			{
				int center = (left + right) / 2;
				mergeSort(a, tmp, left, center);
				mergeSort(a, tmp, center + 1, right);
				merge(a, tmp, left, center + 1, right);
			}
		}


	    private static void merge(Word[ ] a, Word[ ] tmp, int left, int right, int rightEnd )
	    {
	        int leftEnd = right - 1;
	        int k = left;
	        int num = rightEnd - left + 1;

	        while(left <= leftEnd && right <= rightEnd)
	            if(a[left].input.compareTo(a[right].input) <= 0)
	                tmp[k++] = a[left++];
	            else
	                tmp[k++] = a[right++];

	        while(left <= leftEnd)    // Copy rest of first half
	            tmp[k++] = a[left++];

	        while(right <= rightEnd)  // Copy rest of right half
	            tmp[k++] = a[right++];

	        // Copy tmp back
	        for(int i = 0; i < num; i++, rightEnd--)
	            a[rightEnd] = tmp[rightEnd];
	    }
    
    class Word{
    	String input;
    	int index;
    	
    	Word(String input,int index){
    		this.input = input;
    		this.index = index;
    	}
    }
	
}
