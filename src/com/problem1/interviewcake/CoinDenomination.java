package com.problem1.interviewcake;

import java.util.Scanner;

/**
 * https://www.interviewcake.com/question/java/coin
 * Created by sowmyaparameshwara on 4/4/17.
 */
public class CoinDenomination {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        in.nextLine();
        int n = in.nextInt();
        in.nextLine();
        int[] inputDenomination = new int[n];
        for(int i=0; i<n; i++){
            inputDenomination[i] = in.nextInt();
        }
        int numberOfWays = changePossibilitiesBottomUp(amount,inputDenomination);
        System.out.println("numberOfWays : "+numberOfWays);

    }


    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
        int[] numberOfWaysOfDoingNcents = new int[amount+1];
        numberOfWaysOfDoingNcents[0]=1;

        for(int cents : denominations){
            for(int higherAmount = cents; higherAmount<=amount;higherAmount++){
                int higherAmountRemainder = higherAmount-cents;
                numberOfWaysOfDoingNcents[higherAmount]+= numberOfWaysOfDoingNcents[higherAmountRemainder];
            }
        }
        return numberOfWaysOfDoingNcents[amount];
    }
}
