package com.problem1.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution4 {

	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Solution.main() No n :");
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		System.out.println("Solution.main() No k :");
		int k = sc.nextInt();
		
		int result = maxLength(a, k);
		System.out.println("Solution.main() result "+result);
	}*/
	
		
	public static int findMutationDistance(String start, String end, String[] bank)
	{
		List<String> bankList = Arrays.asList(bank);
		/*if(!bankList.contains(start)){
			bankList.add(start);
		}*/
		int res = 0;
		return performMatch(start, end, bankList, res);		
		
	}
	
	public static int performMatch(String startStr, String endStr, List<String> bank, int res){
		ArrayList<String> diffStrings = getDiffIndexes(startStr, endStr);
		int i;
		for(i = 0; i < diffStrings.size(); i++){
			if(bank.contains(diffStrings.get(i))){
				startStr = diffStrings.get(i);
				res++;
				break;
			}
		}
		if(startStr.equals(endStr)){
			return res;
		}
		else if(i >= diffStrings.size()){
			res = -1;
		}
		else{
			res = performMatch(startStr, endStr, bank, res);
		}
		return res;
	}
	
	public static String getValidSeq(List<String> bank, int exceptionIndex, String srcStr, String destStr){
		
		char[] searchChArr = new char[8];
		
		for(int i = 0; i < 8; i++){
			if(i == exceptionIndex){
				searchChArr[i] = destStr.charAt(i);
			}
			else{
				searchChArr[i] = srcStr.charAt(i);
			}
		}
		
		String searchStr = new String(searchChArr);
		if(bank.contains(searchStr)){
			return searchStr;
		}
		return null;
	}
	
	public static ArrayList<String> getDiffIndexes(String startStr, String endStr){
		ArrayList<String> strArray = new ArrayList<String>();
		char[] searchCharArr = startStr.toCharArray();
		char[] temp;
		for(int i = 0; i < 8; i++)
		{
			if(startStr.charAt(i) != endStr.charAt(i))
			{
				 temp = searchCharArr.clone();
				 temp[i] = endStr.charAt(i);
				 strArray.add(new String(temp));
			}
		}
		
		return strArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String startStr = sc.next();
		System.out.println("Solution.main()::startStr " + startStr);
		String endStr = sc.next();
		System.out.println("Solution.main()::endStr " + endStr);
		int n = sc.nextInt();
		System.out.println("Solution.main()::n " + n);

		Set<String> bank = new HashSet<String>();

		for(int i=0; i < n; i++)
		{
			String bankInput = sc.next();
			System.out.println("Solution.main()::bankInput " + bankInput);
			bank.add(bankInput);
		}
		bank.add(startStr);

		String[] strBank = bank.toArray(new String[bank.size()]);

		int res = findMutationDistance(startStr, endStr, strBank);
		System.out.println("Solution.main() res "+res);
	}
	
	/*static int maxLength(int[] a, int k){
		
		int res = 0;
		int localLength = 0;
		int localNoOfWords = 0;
		for(int i = 0; i < a.length; i++){
			System.out.println("Solution.maxLength() =========================");
			System.out.println("Solution.maxLength() i " + i);
			System.out.println("Solution.maxLength() localWords "+localNoOfWords);
			System.out.println("Solution.maxLength() localLength "+localLength);
			for(int j = i; j < a.length; j++){
				localLength += a[j];
				if(localLength <= k){
					localNoOfWords += 1;
				}
				else{
					break;
				}
			}
			System.out.println("Solution.maxLength() i "+i);
			System.out.println("Solution.maxLength() res "+res);
			System.out.println("Solution.maxLength() localWords "+localNoOfWords);
			System.out.println("Solution.maxLength() localLength "+localLength);
			res = Math.max(res, localNoOfWords);
			
			localLength = 0;
			localNoOfWords = 0;
			//System.out.println("Solution.maxLength() ========================= ");
		}
		
		return res;
	}*/
	
	// CODE that worked
/*	static int maxLength(int[] a, int k) {
        int res = 0;
		int localLength = 0;
		int localNoOfWords = 0;
		for(int i = 0; i < a.length; i++){
			for(int j = i; j < a.length; j++){
				localLength += a[j];
				if(localLength <= k){
					localNoOfWords += 1;
				}
				else{
					break;
				}
			}
			res = Math.max(res, localNoOfWords);
			
			localLength = 0;
			localNoOfWords = 0;
		}
		
		return res;

    }
*/


}
