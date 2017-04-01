package com.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sowmyaparameshwara on 12/17/16.
 */
public class BubbleSort {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the number of elements");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] input = new int[size];
        System.out.println("Enter the inputs");
        for(int i = 0 ; i < size; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        bubbleSort(input);
        System.out.println("Sorted output");
        for(int i = 0 ; i < size; i++){
            System.out.print(" "+input[i]+" ");
        }
    }

    private static void bubbleSort(int[] input) {
        for (int i = 1 ; i < input.length ; i++){
            boolean flag = false;
            for(int j = 0 ; j < input.length-i ; j++){
                if(input[j]>input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
