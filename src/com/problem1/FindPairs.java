package com.problem1;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/13/17.
 */
public class FindPairs {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = in.nextInt();
        }
        FindPairs p = new FindPairs();
        p.calculateEqualProducts(input);
    }

    private void calculateEqualProducts(int[] input) {
        HashMap<Integer,String> map= new HashMap<>();
        for(int i = 0 ;i<input.length; i++){
            for(int j=i+1;j<input.length; j++){
                int prod = input[i]*input[j];
                if(map.containsKey(prod)){
                    String[] value = map.get(prod).split(" ");
                    System.out.println("Pair found, a : "+value[0]+" b : "+value[1]);
                    System.out.println("Pair found, c : "+input[i]+" d : "+input[j]);
                    return;
                }
                map.put(prod,input[i]+" "+input[j]);
            }
        }
        System.out.println("No paif found here");
    }
}
