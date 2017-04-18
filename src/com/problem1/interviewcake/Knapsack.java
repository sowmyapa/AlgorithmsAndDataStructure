package com.problem1.interviewcake;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/14/17. using knapsack algorithm
 */

class CakeType {

    int weight;
    int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value  = value;
    }

}

public class Knapsack {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter total capacity ");
        int w = in.nextInt();
        in.nextLine();
        System.out.println("Enter number of items");
        int n = in.nextInt();
        in.nextLine();
        CakeType[] cakeType = new CakeType[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter weight and value");
            cakeType[i] = new CakeType(in.nextInt(),in.nextInt());
            in.nextLine();
        }
        Knapsack c = new Knapsack();
        c.determineBestCombination(w,cakeType);
    }

    private void determineBestCombination(int weight,CakeType[] cakeTypes) {
        int[][] knapsack = new int[weight+1][cakeTypes.length+1];
        for(int i=0;i<=weight;i++){
            for(int j=0;j<=cakeTypes.length;j++){
                if(i==0 || j==0){
                    knapsack[i][j] = 0;
                }else if(cakeTypes[j-1].weight<=i){
                    knapsack[i][j] = Math.max(knapsack[i][j-1], knapsack[i-cakeTypes[j-1].weight][j-1]+cakeTypes[j-1].value);
                }else{
                    knapsack[i][j] = knapsack[i][j-1];
                }

            }
        }
        System.out.println("Max value : "+knapsack[weight][cakeTypes.length]);

    }


}
