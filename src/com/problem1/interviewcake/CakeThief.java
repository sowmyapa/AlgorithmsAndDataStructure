package com.problem1.interviewcake;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/14/17.
 * Unbounded knapsack
 * https://www.interviewcake.com/question/java/cake-thief
 **/


public class CakeThief {

    static class InfinityException extends RuntimeException {
        public InfinityException() {
            super("Max value is infinity!");
        }
    }

    static class CakeType {

        int weight;
        int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }

    }

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
        CakeThief c = new CakeThief();
        c.maxDuffelBagValue(cakeType,w);
    }

    public void maxDuffelBagValue(CakeType[] cakeTypes, int w) {
        long[] bestWeightCapacities = new long[w+1];
        for(int currentCapacity=0; currentCapacity<=w; currentCapacity++){
            long maxCapacity = 0L;
            for(CakeType cakeType : cakeTypes){
                if (cakeType.weight == 0 && cakeType.value != 0) {
                    throw new InfinityException();
                }

                if(cakeType.weight<=currentCapacity) {
                    long capacity = cakeType.value + bestWeightCapacities[currentCapacity - cakeType.weight];
                    maxCapacity = Math.max(capacity, maxCapacity);
                }
            }
            bestWeightCapacities[currentCapacity]=maxCapacity;
        }
        System.out.println("Best capacity : "+bestWeightCapacities[w]);
    }



}
