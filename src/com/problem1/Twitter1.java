package com.problem1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class Twitter1 {
	
	public static int REVERSE=1;
	public static int SIMPLIFY=2;
	public static int SIMPLIFY_REVERSE=3;
	public static int NONE=4;		
	
	public static void main(String[] args) throws NoSuchElementException{
	    Scanner in = new Scanner(System.in);
	    
	    while(in.hasNextLine()){
	    	
	    	String input = in.nextLine();
	    	if(input.isEmpty()){
	    		break;
	    	}
	    	String[] splitInputExpression = input.split("/");
	    	String expression = splitInputExpression[0];
	    	String operation="";
	    	if(splitInputExpression.length==2)
	    	    operation = splitInputExpression[1];
	    	
	    	handleTransformation(expression,operation);

	    }
	}

	private static void handleTransformation(String expression, String operation) {
		// TODO Auto-generated method stub

	   if(operation.isEmpty()){
		   for(int i=0;i<expression.length();i++){
			   if(expression.charAt(i)!=' ')
			    System.out.print(expression.charAt(i));
		   }
		   System.out.println();
	   }else{
		   
		   handleTranformationWithOperation(expression,operation);
	   }

		
	}

	private static void handleTranformationWithOperation(String expression, String operation) {
		int countR=0,countS=0;
		for(int i =0;i<operation.length();i++)
		{
			char op=operation.charAt(i);
			if(op=='R'){
				expression=performReverse(expression);
			}else if(op=='S'){
				expression=performSimplify(expression);
			}
		}
		System.out.println(expression);
		/*int operationType=0;
		if(countR%2==0 && countS>0){
			performSimplify(expression);
		}else if(countR%2==1 && countS>0){
			performSimplifyReverse(expression,operation);
		}else if(countR%2==1){
			performReverse(expression);
		}else{
			printOutput(expression);
		}*/
		
		
	}

	
	


	private static String performReverse(String expression) {
		Stack inputStack=new Stack();
		String output="";
		for(int i=0;i<expression.length();i++){
			if(expression.charAt(i)!=' '){
				inputStack.push(expression.charAt(i));
			}
		}
		while(!inputStack.isEmpty()){
			char symbol=(char) inputStack.pop();
			if(symbol==')'){
				output=output.concat(String.valueOf("("));
			}else if(symbol=='('){
				output=output.concat(String.valueOf(")"));
			}else{
				output=output.concat(String.valueOf(symbol));

			}
		}
		return output;
		
	}
	

	
	

	
	
	private static String performSimplify(String expression) {

		String simplified="";
		int openingBracket=0;
		int unnecessaryBracket=0;
		 
		for(int i=0;i<expression.length();i++){
			char symbol = expression.charAt(i);
			if(symbol=='(' && (i==0 || expression.charAt(i-1)=='(')){
			
				expression=performSimplify(elieminateBrackets(expression,i));
				break;
			}
		}
		return expression;		

	}

	private static String elieminateBrackets(String expression,int start) {
		
		int openBracket=0;
		// TODO Auto-generated method stub
		String output=expression.substring(0, start);
		boolean found=false;
		for(int i=start+1;i<expression.length();i++){
			char symbol = expression.charAt(i);
			if(symbol=='('){
				output=output.concat(String.valueOf(expression.charAt(i)));
				openBracket++;
			}else if(symbol==')' && (openBracket>0 || found)){
				output=output.concat(String.valueOf(expression.charAt(i)));
				openBracket--;
			}else if(symbol!=')') {
				output=output.concat(String.valueOf(expression.charAt(i)));
			}else if(symbol==')'){
				found=true;
			}

		}
		return output;
	}
	
	

}
