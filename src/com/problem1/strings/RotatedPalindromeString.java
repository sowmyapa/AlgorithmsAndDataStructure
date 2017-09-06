package com.problem1.strings;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 9/3/17.
 */
public class RotatedPalindromeString {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        boolean res = isRotatedPalindrome(input);
        System.out.println(res);
    }

    private static boolean isRotatedPalindrome(String input) {
        if(input.length()%2==0){
            return isRotatedPalindromeEvenLength(input);
        }else{
            return isRotatedPalindromeOddLength(input);
        }
    }

    private static boolean isRotatedPalindromeOddLength(String input) {
        char[] indexArray = new char[26];
        for(int i=0;i<input.length();i++){
            indexArray[input.charAt(i)-'a']++;
        }
        boolean isPalindrome=true;
        outer: for(int i=0;i<input.length();i++) {
            int occurence = indexArray[input.charAt(i) - 'a'];
            if (occurence % 2 == 1) {
                int index = occurence/2+i;
                int right = (index + 1) % input.length();
                int left = (index +input.length()-1) % input.length();
                int n = input.length()/2;
                while (n>=0) {
                    if (input.charAt(left) == input.charAt(right)) {
                        left = (left +input.length()- 1) % input.length();
                        right = (right + 1) % input.length();
                        n--;
                    } else {
                        isPalindrome = false;
                        break outer;
                    }
                }
                break outer;

            }
        }
        return isPalindrome;
    }

    private static boolean isRotatedPalindromeEvenLength(String input) {
        boolean isPalindrome=true;
        char prev=input.charAt(0);
        char cur;
        outer: for(int i=1;i<input.length();i++) {
            cur = input.charAt(i);
            if(prev==cur){
                int right = (i + 1) % input.length();
                int left = (i + (input.length()-2)) % input.length();
                int n = input.length()/2-2;
                while (n>=0) {
                    if (input.charAt(left) == input.charAt(right)) {
                        left = (left + (input.length()-1)) % input.length();
                        right = (right +1) % input.length();
                        n--;
                    }else{
                        isPalindrome =false;
                        break outer;
                    }
                }
            }else{
                prev = cur;
            }
        }
        return isPalindrome;
    }

}
