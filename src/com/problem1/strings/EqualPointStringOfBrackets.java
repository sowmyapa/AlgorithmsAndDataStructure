package com.problem1.strings;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/9/17.
 * http://www.geeksforgeeks.org/find-equal-point-string-brackets/
 */
public class EqualPointStringOfBrackets {

    public  static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int k = determineEqualPoint(input);
        System.out.println("index : "+k);
    }

    private static int determineEqualPoint(String input) {
        int index;
        int[] open = new int[input.length()];
        int[] close = new int[input.length()];


        if(input.charAt(0)=='('){
            open[1]=1;
        }
        if(input.charAt(input.length()-1)==')'){
            close[close.length-1]=1;
        }
        for(int i=1;i<input.length()-1;i++){
            if(input.charAt(i)=='('){
                open[i+1]=open[i]+1;
            }else{
                open[i+1]=open[i];
            }
        }
        for(int i=input.length()-2;i>=0;i--){
            if(input.charAt(i)==')'){
                close[i]=close[i+1]+1;
            }else{
                close[i]=close[i+1];
            }
        }

        if(open[input.length()-1]==0)
            return input.length();
        if(close[0]==0)
            return 0;
        for(int i=0;i<open.length;i++){
            if(open[i]==close[i]){
                return i;
            }
        }
        return -1;

    }

}
