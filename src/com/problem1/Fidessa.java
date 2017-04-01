package com.problem1;

import java.util.Scanner;
import java.util.Stack;

public class Fidessa {
	
	public static void main(String[] args){
	    Scanner in = new Scanner(System.in);
	    int index = findMatchingIndex(in.nextLine());
	    System.out.println(index);
	}

	private static int findMatchingIndex(String input) {
		int index=-1;
		Stack stack = new Stack();
		for(int i=0;i<input.length();i++){
			char a = input.charAt(i);
			if(Character.isUpperCase(a)){
				stack.push(a);
			}else if(!stack.isEmpty()){
				char element = (char) stack.pop();
				if(element==Character.toUpperCase(a)){
					index=i;
				}else{
					break;
				}
			}else{
				break;
			}
			
		}
		return index;
	}

}
