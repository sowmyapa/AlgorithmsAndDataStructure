package com.problem1.interviewcake;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/2/17.
 * https://www.interviewcake.com/question/java/product-of-other-numbers
 */
public class ProductOfAllIntsExceptAtThatIndex {

    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       int numberOfElements = in.nextInt();
        in.nextLine();
        int[] input = new int[numberOfElements];
        for(int i=0; i<numberOfElements; i++){
            input[i] = in.nextInt();
        }
        computeProduct(input);

    }

    private static void computeProduct(int[] input) {
        // make sure we have at least 2 numbers
        if(input.length<2){
            throw new IllegalArgumentException("Requires atleast two elements");
        }
        // we make an array with the length of the input array to
        // hold our products
        int[] productOfAllExceptAtIndex = new int[input.length];

        // for each integer, we find the product of all the integers
        // before it, storing the total product so far each time
        int productSoFar=1;
        //before that index
        for(int i=0;i<input.length;i++){
            productOfAllExceptAtIndex[i]=productSoFar;
            productSoFar*=input[i];
        }
        productSoFar=1;
        //after that index and hence at that index;
        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        for(int i=input.length-1;i>=0;i--){
            productOfAllExceptAtIndex[i]*=productSoFar;
            System.out.println("i: "+i+"product: "+productOfAllExceptAtIndex[i]);

            productSoFar*=input[i];
        }




    }

}
