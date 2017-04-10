package com.problem1.strings;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/9/17.
 * http://www.geeksforgeeks.org/lexicographically-first-palindromic-string/
 */
public class PalindromicString {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        PalindromicString p = new PalindromicString();
        p.findPalindromicString(input);
    }

    private void findPalindromicString(String input) {
        int[] freq = computeFrequencies(input);
        if(isValidPalindromicString(freq,input)){
            createPalindromeString(input,freq);
        }else{
            System.out.println("Palindrome string not possible");
        }
    }

    private void createPalindromeString(String input, int[] freq) {
        String odd_str="";
        if(input.length()%2!=0){
            odd_str=getOddString(input,freq);
        }
        String prefix_even="";
        String suffix_even="";
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                char c = (char) (i+'a');
                String temp = String.valueOf(c);
                for(int j=1;j<freq[i]/2;j++){
                    temp=temp+c;
                }
                prefix_even = prefix_even+temp;
                suffix_even = temp+suffix_even;
            }
        }
        System.out.println("Palindrome string "+(prefix_even+odd_str+suffix_even));
    }

    private String getOddString(String input, int[] freq) {
        String odd_str="";
        for(int i=0;i<freq.length;i++){
            if(freq[i]%2!=0){
                char c = (char) (i+'a');
                freq[i]--;
                odd_str= String.valueOf(c);
            }
        }
        return odd_str;
    }

    private boolean isValidPalindromicString(int[] freq,String input) {
        boolean isValid = true;
        int oddCount=0;
        int length = input.length();
        for(int i=0;i<freq.length;i++){
            if(freq[i]%2!=0){
                oddCount++;
                if(length%2==0){
                    isValid = false;
                    return isValid;
                }else if(oddCount>1){
                    isValid = false;
                    return isValid;
                }
            }
        }
        return isValid;
    }

    private int[] computeFrequencies(String input) {
        int[] freq = new int[26];
        for(int i = 0;i<input.length();i++){
            freq[input.charAt(i)-'a']++;
        }
        return freq;
    }


}
