package com.problem1.testdome;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sowmyaparameshwara on 5/5/17.
 */
public class SortedSearch {

    public static int countNumbers(int[] sortedArray, int lessThan) {
        int low = 0;
        int high = sortedArray.length-1;
        int mid=0;
        boolean found=false;
        if(sortedArray[low]>lessThan){
            return 0;
        }else if(sortedArray[high]<lessThan){
            return sortedArray.length;
        }
        int count=0;
        while(low<high){
            mid = (low+high)/2;
            if(sortedArray[mid]==lessThan){
                found=true;
                count=mid;
                break;
            }
            if(sortedArray[mid]<lessThan){
                low=mid+1;
            }
            if(sortedArray[mid]>lessThan){
                high=mid-1;
            }
        }
        if(found){
            while(sortedArray[mid]>=lessThan && mid!=0) {
                mid--;
                count=mid+1;
            }
        }else{
            if(sortedArray[mid]<lessThan){
                while(sortedArray[mid]<lessThan && mid!=sortedArray.length-1) {
                    mid++;
                    count=mid;
                }
            }else {
                while (sortedArray[mid] >= lessThan && mid!=0) {
                    mid--;
                    count=mid+1;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { -1,1,2,2,2,2,2,2,2,2, 3, 5, 7,10,11,12,13 },2));
    }

}
