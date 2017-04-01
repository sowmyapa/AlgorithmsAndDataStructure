package com.problem1.dp;

import java.util.Stack;

public class BalancedParenthesisGD {
    public static void main (String [] args)
    {
        String test_good = "()(){}{}{()}";
        String test_bad = "((({}{}))()";

        System.out.println(checkBalanced(test_good));
        System.out.println(checkBalanced(test_bad));
    }

    public static boolean checkBalanced(String temp)
    {
        Stack<Character> S = new Stack<Character>();
        for(int a = 0; a < temp.length(); a++)
        {
            char let = temp.charAt(a);
            if(let == '[' || let == '{' || let == '(')
                S.push(let);
            else if(let == ']' || let == '}' || let == ')')
            {
                if(S.empty())
                    return false;
                switch(let)
                {
                    case ']':
                        if (S.pop() != '[')
                            return false;
                        break;
                    case '}':
                        if (S.pop() != '{')
                            return false;
                        break;
                    case ')':
                        if (S.pop() != '(')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if(S.empty())
            return true;
        return false;
    }
}