package com.problem1.ctci.chapter1;

/**
 * Created by sowmyaparameshwara on 5/22/17.
 * URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith " J 13 Output: "Mr%20J ohn%20Smith"
 */
public class URLify {

    public static void main(String[] args){
        String str = "Mr John Smith    ";
        char[] charArray = str.toCharArray();
        int trueLength = determineTrueLength(charArray);
        replaceSpaces(charArray,trueLength);
        System.out.println(new String(charArray));
    }


    private static void replaceSpaces(char[] charArray, int trueLength) {
        int indexToInsert = 0;
        int noOfSpaces=0;
        for(int i=0;i<trueLength;i++){
            if(charArray[i]==' ')
                noOfSpaces++;
        }
        indexToInsert = trueLength+2*noOfSpaces-1; //since %20 requires 3 characters,out of which 1 character is already part of string
        for(int i=trueLength-1;i>=0;i--){
            if(charArray[i]==' '){
                charArray[indexToInsert-2]='%';
                charArray[indexToInsert-1]='2';
                charArray[indexToInsert]='0';
                indexToInsert -=3;
            }else{
                charArray[indexToInsert--]=charArray[i];
            }
        }
    }

    /**
     * returns the actual length of string after removing trailing whitespaces
     * @param charArray
     * @return
     */
    private static int determineTrueLength(char[] charArray) {
        for(int i=charArray.length-1;i>=0;i--){
            if(charArray[i]!=' '){
                return i+1;
            }
        }
        return 0;
    }
}
