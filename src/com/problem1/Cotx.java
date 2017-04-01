package com.problem1;

import java.util.Scanner;

public class Cotx {
	  public static void main(String[] args){
	        int output=0;
	        for(int i=0;i<50;i++){
	        int result = fibonacci(i);
	        if(result%2==0){
	            output++;
	            System.out.print(" "+result);
	        }
	        if(output==15){
	            break;
	        }
	        }
	        
	    }
	    public static int fibonacci(int n){
	        if(n==0){
	            return 0;
	        }else if(n==1){
	            return 1;
	        }else{
	            return fibonacci(n-1)+fibonacci(n-2);
	        }
	        
	    }

}
