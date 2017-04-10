package com.problem1.memoization;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/2/17.
 */
public class Fibonacci {

    private HashMap<Integer,Integer> memoization;

    Fibonacci(){
        memoization = new HashMap<>();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        Fibonacci fib = new Fibonacci();

        int res = fib.computeFibonacci(input);
        System.out.println("Result is : "+res);
    }

    private int computeFibonacci(int input) {
        if(input<0){
            throw new IllegalArgumentException("Input needs to be greater then zero");
        }
        if(input==0 || input==1)
            return input;
        else{
            int result = 0;
            if(memoization.containsKey(input)){
                System.out.println("Grabbing from map for "+input);
                result = memoization.get(input);
            }else {
                System.out.println("computing"+(input-1)+" "+(input-2)+" for "+input);
                 result = computeFibonacci(input - 1) + computeFibonacci(input - 2);
                memoization.put(input,result);
            }
            return result;

        }
    }
}
