package com.problem1.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sowmyaparameshwara on 5/28/17.
 */
public class Solution {

    public static  void main(String[] args){
        Solution s = new Solution();
        //s.calculate();
    String[] values = new String[]{"{}[]()","{[}]"};

    String[] result = braces(values);
        for(String r: result){
            System.out.println(r);
        }
    }

    private void calculate() {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int p = in.nextInt();
            System.out.println(" n "+n+" p "+p);

        }

    }

    static String[] braces(String[] values) {
        String[] result = new String[values.length];
        for(int i=0;i<values.length;i++){
            String temp=values[i];
            result[i] = checkBalanced(temp);

        }

        return result;
    }

    private static String checkBalanced(String temp) {
        Stack<Character> S = new Stack<Character>();
        for(int a = 0; a < temp.length(); a++)
        {
            char let = temp.charAt(a);
            if(let == '[' || let == '{' || let == '(')
                S.push(let);
            else if(let == ']' || let == '}' || let == ')')
            {
                if(S.empty()){
                    return "NO";
                }
                switch(let)
                {
                    case ']':
                        if (S.pop() != '['){
                            return "NO";
                        }
                        break;
                    case '}':
                        if (S.pop() != '{'){
                            return "NO";
                        }
                        break;
                    case ')':
                        if (S.pop() != '('){
                            return "NO";
                        }
                        break;
                    default:
                        break;
                }
            }

        }
        if(S.empty())
            return "YES";
        else
            return "NO";
    }


}
