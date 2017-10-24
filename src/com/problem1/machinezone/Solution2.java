package com.problem1.machinezone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by sowmyaparameshwara on 10/23/17.
 * Range Overlap
 */
public class Solution2 {

    ArrayList<Interval> arr = new ArrayList();

    static class Interval {
        int startTime;
        int endTime;

        Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public void add(int start,int end){
        arr.add(new Interval(start,end));
    }

    public int getOverlap(){
        return determineMaxOverlap();
    }

    private int determineMaxOverlap() {
        int result = 0;
        Collections.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.startTime-o2.startTime;
            }
        });
        Stack<Interval> s = new Stack();
        int curInterval = 0;
        for(int i=0;i<arr.size();i++){
            Interval temp = arr.get(i);
            if(s.empty()){
                s.push(temp);
                curInterval = 1;
                result = Math.max(result,curInterval);
            }else{
                Interval top = s.peek();
                if(top.endTime>=temp.startTime){
                    top.endTime=Math.max(top.endTime,temp.endTime);
                    curInterval++;
                    result = Math.max(result,curInterval);
                }else{
                    s.push(temp);
                    curInterval = 1;
                    result = Math.max(result,curInterval);
                }
            }
        }
        return result;
    }


}
