package com.problem1.dp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution7 {

	public static void main(String[] args) {

		Solution7 sol = new Solution7();
		Scanner in = new Scanner(System.in);
		
		System.out.println(sol.findRepeatingLetter(in.next()));
		
		in.close();
	}

	public String findRepeatingLetter(String input){
		int curVal = 0;
		LinkedHashMap<String, Integer> lhMap = new LinkedHashMap<String, Integer>();
		for(int i = 0; i < input.length(); i++){
			String key = Character.toString(input.charAt(i));
			if(lhMap.containsKey(key)){
				curVal = lhMap.get(key);
				lhMap.put(key, ++curVal);
			}
			else{
				lhMap.put(Character.toString(input.charAt(i)), 1);
			}
		}
		
		for(Map.Entry<String, Integer> currentEntry : lhMap.entrySet()){
			if(currentEntry.getValue() > 1){
				return currentEntry.getKey();
			}
		}
		return "NA";
	}
}
