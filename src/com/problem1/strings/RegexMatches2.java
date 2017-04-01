package com.problem1.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sowmyaparameshwara on 3/22/17.
 * You can see that this example uses word boundaries to ensure that the
 * letters "c" "a" "t" are not merely a substring in a longer word. It also gives some useful information
 * about where in the input string the match has occurred.
 */
public class RegexMatches2 {

    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT = "cat cat cat cattie cat";

    public static void main( String args[] ) {

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        int count=0;
        while(m.find()){
            count++;
            System.out.println("Count : "+count);
            System.out.println("Start : "+m.start());
            System.out.println("Ends : "+m.end());

        }
    }
}
