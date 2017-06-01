package com.problem1.hackerrank;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sowmyaparameshwara on 5/28/17.
 *
 *
 *
 */
public class FindNumber {

    static String findNumber(int[] arr, int k) {
        Arrays.sort(arr);
        if(arr.length==0){
            return "NO";
        }
        int low =0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==k){
                return "YES";
            }else if(arr[mid]<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return "NO";

    }

    static int[] oddNumbers(int l, int r) {
        if(l>r){
            return null;
        }
        int start = (l%2)!=0?l:l+1;

        ArrayList<Integer> result = new ArrayList<Integer>();
        while(start<=r){
            result.add(start);
            start+=2;
        }
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = result.get(i);
        }
        int[] array = result.stream().mapToInt(i->i).toArray();
        return finalResult;


    }

}
