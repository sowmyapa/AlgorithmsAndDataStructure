package com.problem1.interviewcake;

import java.util.*;

/**
 * Created by sowmyaparameshwara on 4/3/17.
 */
public class MergingOverlappingIntervals {


    static class Interval{
        int startTime;
        int endTime;

        Interval( int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }


        public String toString(){
             return "{"+startTime+","+endTime+"}";
        }
    }

    public static void main(String[] args){
        ArrayList<Interval> arr = new ArrayList<>();
        /*arr.add(new Interval(6,8));
        arr.add(new Interval(1,9));
        arr.add(new Interval(2,4));
        arr.add(new Interval(4,7));*/

        arr.add(new Interval(0,1));
        arr.add(new Interval(3,5));
        arr.add(new Interval(4,8));
        arr.add(new Interval(10,12));
        arr.add(new Interval(9,10));

        findMergedIntervals(arr);
    }

    private static void findMergedIntervals(ArrayList<Interval> arr) {
        Collections.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.startTime-o2.startTime;
            }
        });
        Stack<Interval> s = new Stack();
        for(int i=0;i<arr.size();i++){
            Interval temp = arr.get(i);
            if(s.empty()){
               s.push(temp);
            }else{
                Interval top = s.peek();
                if(top.endTime>=temp.startTime){
                    top.endTime=Math.max(top.endTime,temp.endTime);
                }else{
                    s.push(temp);
                }
            }
        }
        while(s.size()>0){
            System.out.println(s.pop());
        }

    }
}
