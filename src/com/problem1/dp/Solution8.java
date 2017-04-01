package com.problem1.dp;

import java.util.Scanner;
import java.util.Stack;

public class Solution8 {

	public static void main(String[] args) {

		Solution8 s = new Solution8();
		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			s.processInput(in.nextLine());
		}
	}

	public void processInput(String s) {
		String[] parts = s.split("/");
		String exp = parts[0].trim();
		String operations = parts[1];

		String result = exp;
		for (char operation : s.toCharArray()) {
			if (operation == 'R') {
				result = performReverse(new Stack<String>(), result, 0, true);
			}
			if (operation == 'S') {
				result = performSimplify(new Stack<String>(), result);
			}
		}
		System.out.println("result : "+result);
	}

	private String performSimplify(Stack<String> stack, String input) {

		StringBuffer result = new StringBuffer();
		return null;
	}

	private String performReverse(Stack<String> stack, String input, int index, boolean flag) {

		StringBuffer result = new StringBuffer();
		
		for (int i = index; i < input.length(); i++) {

			switch (input.charAt(i)) {
			case ' ' :
				// neglect the spaces
				break;
				
			case '(' :
				Stack<String> subStack = new Stack<String>();
				subStack.push("(");
				String tempResult = performReverse(subStack, input, i+1, false);
				
				stack.push(tempResult);
				i += tempResult.length() - 1;
				break;
			
			case ')' : 
				result.append("(");
				int stackSize = stack.size();
				for(int j = 0; j < stackSize; j++){
					String poppedVal = stack.pop();
					if(poppedVal.equals("(")){
						result.append(")");
					}
					else{
						result.append(poppedVal);
					}
					
				}
				if(flag){
					break;
				}
				else{
					return result.toString();	
				}
				
			default:
				stack.push(Character.toString(input.charAt(i)));
				break;
			}
		}
		
		int stackSize = stack.size();
		for(int j = 0; j < stackSize; j++){
			String poppedVal = stack.pop();
			if(poppedVal.equals("(")){
				result.append(")");
			}
			else{
				result.append(poppedVal);
			}
			
		}
		
		return result.toString();
	}

}
