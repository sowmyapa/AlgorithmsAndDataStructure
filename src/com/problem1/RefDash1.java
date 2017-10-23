package com.problem1;

public class RefDash1 {

}

/*
package com.problem1;

import java.util.Arrays;

*/
/**
 * Created by sowmyaparameshwara on 10/20/17.
 *//*

public class RefDash1 {

    */
/*
5 4 3 2 1 5 2 4 5 1 1 2 3  0
1 1 1 1 1
    5 4 3 2 1
 2  2  2  2  1

1 2 3 4 5 1
1 1 1 1 1
 1  2  3  4 5
1 2 2 2 2




*//*

    int findMinimumCandies(int[] studentRanks){
        int[] candies = new int[studentRanks.length];
        int slopeStartIndex=0;
        for(int i=1 ; i< studentRanks.length-1;i++){
            if(studentRanks[i]<studentRanks[i+1]){
                while(studentRanks[i]<studentRanks[i+1]){
                    i++;
                }
                int temp = i;
                int value=i-slopeStartIndex;
                while(temp>slopeStartIndex){
                    candies[i]=value;
                    value--;
                    temp--;
                }
                slopeStartIndex=i+1;
            }else{
                while(studentRanks[i]>studentRanks[i+1]){
                    i++;
                }
                int temp = i;
                int value=1;
                while(temp>slopeStartIndex){
                    candies[i]=value;
                    value++;
                    temp--;
                }
                slopeStartIndex=i+1;
            }

        }

*/








    /*int findMinimumCandies(int[] studentRanks){
        int[] candies = new int[studentRanks.length];
        Arrays.fill(candies,1);
        for(int i=0 ; i< studentRanks.length-1;i++){
            if(studentRanks[i]>studentRanks[i+1]){
                candies[i] = candies[i+1]+1;
            }
        }
        int totalCandies=0;

        for(int i=studentRanks.length-1; i >=1;i--){
            if(studentRanks[i]>studentRanks[i-1]){
                candies[i] = candies[i-1]+1;
            }else if(studentRanks[i]==studentRanks[i-1]){
                candies[i] = candies[i-1];
            }
            totalCandies+=candies[i];
        }
        return totalCandies;
    }*/


