package com.problem1.ctci.chapter1;

/**
 * Created by sowmyaparameshwara on 5/22/17.
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    public static void main(String[] args){
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for(String word : words){
            System.out.println("word : "+word+" isUnique : "+isUnique1(word));
            System.out.println("word : "+word+" isUnique : "+isUnique2(word));

        }
    }

    private static boolean isUnique1(String word) {
        if(word.length()>128){
            return false;
        }
        boolean[] charSet = new boolean[128];
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(charSet[c])
                return false;
            charSet[c] = true;
        }
        return true;
    }

    private static boolean isUnique2(String word) {
        if(word.length()>26){
            return true;
        }
        int checker=0;
        for(int i=0;i<word.length();i++){
            int val = word.charAt(i)-'a'; //getting ascii value of each character mapped to an index between 0 to 25
            int bitVal = 1<<val; //1 << val creates an int value that has all bits zero except for the valth bit.
            if((checker&bitVal)>0) //If the bit at position val in checker is already set, then this evaluates to a nonzero value (meaning we've already seen the number) and we can return false. Otherwise, it evaluates to 0, and we haven't seen the number.
                return false;
            checker = checker | bitVal; //This ORs checker with a value that has a 1 bit set only at position val, which turns the bit on. It's equivalent to setting the valth bit of the number to 1.
        }
        return true;
    }

}
