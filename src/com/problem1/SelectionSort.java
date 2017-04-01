package com.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sowmyaparameshwara on 12/18/16.
 */
public class SelectionSort {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the number of elements");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] input = new int[size];
        System.out.println("Enter the inputs");
        for(int i = 0 ; i < size; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        selectionSort(input);
        System.out.println("Sorted output");
        for(int i = 0 ; i < size; i++){
            System.out.print(" "+input[i]+" ");
        }
    }

    private static void selectionSort(int[] input) {
        int size = input.length;
        for(int i = 0; i < size-1 ; i++){
            int minIndex = i;
            for(int j = i ; j < size; j++){
                if(input[j]<input[minIndex]){
                    minIndex = j;
                }
            }
            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
        }
    }

}
