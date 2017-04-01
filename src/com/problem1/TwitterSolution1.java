package com.problem1;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 2/26/17.
 */
public class TwitterSolution1 {

    public static void main(String[] args){
       Scanner in = new Scanner(System.in);


    }

    static int maxLength(int[] a, int k) {


        int max=-1;


        outer:for (int i = 0; i < (1<<a.length); i++)
        {

            int res=0,sum=0;

            for (int j = 0; j < a.length; j++){
                if ((i & (1 << j)) > 0){

                    res++;
                    sum+=a[j];
                    if(sum>k){
                        continue outer;
                    }

                    if(res>max && sum<=k){
                        max=res;
                    }

                }

            }


        }


        return max;

    }

}
