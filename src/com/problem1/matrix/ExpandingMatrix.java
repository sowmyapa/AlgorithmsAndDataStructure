package com.problem1.matrix;

/**
 * http://www.geeksforgeeks.org/return-previous-element-in-an-expanding-matrix/
 */
public class ExpandingMatrix {

    public static void main(String[] args){
        String input = "aacbddc";
        System.out.println(findLeft(input));
    }

    private static String findLeft(String input) {
        char[] output = input.toCharArray();
        for(int i=output.length-1;i>=0; i--){
            if(output[i]=='b') {
                output[i] = 'a';
                break;
            }
            else if(output[i]=='d') {
                output[i] = 'c';
                break;
            }
            if(output[i]=='a') {
                output[i] = 'b';
            }
            else if(output[i]=='c') {
                output[i] = 'd';
            }
        }
        return new String(output);
    }

}
