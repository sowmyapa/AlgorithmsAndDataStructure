package com.problem1;

import java.util.Scanner;
import java.util.Stack;

public class BalancedString {
	
	public static void main(String []argh)
	   {
	      Scanner sc = new Scanner(System.in);
	      
	      while (sc.hasNext()) {
	         String input=sc.next();
/*	         while(input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
	         System.out.println(input.isEmpty());*/
	         boolean result = checkBalance(input);
	         System.out.println(result);
	      }
	      
	   }

	private static boolean checkBalance(String input) {
		Stack s = new Stack();
		boolean result = true;
		for(int i=0; i <input.length();i++){
			char c = input.charAt(i);
			char inStack ;
			switch(c){
			
			case ')':if(s.isEmpty()){
				        result = false;
			          }else{
				
				 inStack = (char) s.pop();
                if(inStack!='('){
               	 result = false;
                }
			          }
           	 break;
			case '}':
				if(s.isEmpty()){
			        result = false;
		          }else{
			
			 inStack = (char) s.pop();
            if(inStack!='{'){
           	 result = false;
            }
		          }
           	 break;
			case ']':
				if(s.isEmpty()){
			        result = false;
		          }else{
			
			 inStack = (char) s.pop();
            if(inStack!='['){
           	 result = false;
            }
		          }
            	 break;
			
			case '(':
			case '{':
			case '[':
				s.push(c);
				break;
			}
			if(result==false){
				break;
			}
		   
			
		}
		if(!s.isEmpty()){
			result=false;
		}
		return result;
	}

}
