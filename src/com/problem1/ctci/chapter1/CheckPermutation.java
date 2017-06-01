package com.problem1.ctci.chapter1;

import java.util.Arrays;

/**
 * Created by sowmyaparameshwara on 5/22/17.
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {

    public static void main(String[] args){
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for( String[] pair : pairs){
            System.out.println(pair[0]+" "+pair[1]+" is permutation : "+isPermutation1(pair[0],pair[1]));
            System.out.println(pair[0]+" "+pair[1]+" is permutation : "+isPermutation2(pair[0],pair[1]));
        }

    }

    private static boolean isPermutation1(String s1, String s2) {
        if(sort(s1).equals(sort(s2))){
            return true;
        }
        return false;
    }

    private static String sort(String s1) {
        char[] charArray = s1.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private static boolean isPermutation2(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int[] charArray = new int[128];
        for(int i=0;i<s1.length();i++){
            charArray[s1.charAt(i)]++;
        }
        for(int i=0;i<s2.length();i++){
            charArray[s2.charAt(i)]--;
            if(charArray[s2.charAt(i)]<0) //this works since we know both strings are of same length
                return false;
        }
        return true;
    }

}
