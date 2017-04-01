package com.problem1.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sowmyaparameshwara on 3/22/17.
 */
public class UberStringMatching {

    //private static String REGEX = "a{0,3}b{0,4}";
    //private static String INPUT = "aaabbbb";

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String regexInput = in.next();
        String textInput = in.next();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<regexInput.length();i++){
            char c = regexInput.charAt(i);
            if(c=='('){
                sb.append("{0,").append(regexInput.charAt(++i)).append("}");
                ++i;
            }else if(c!=')'){
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        Pattern p = Pattern.compile(sb.toString());
        Matcher m = p.matcher(textInput);
        System.out.println(m.matches());

    }

}
