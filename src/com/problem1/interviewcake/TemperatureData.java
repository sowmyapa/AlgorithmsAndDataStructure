package com.problem1.interviewcake;

import java.util.HashMap;

/**
 * Created by sowmyaparameshwara on 4/6/17.
 */
public class TemperatureData {


    int max;
    int min=Integer.MAX_VALUE;
    float mean;
    int totalNumber;
    int totalSum;
    HashMap<Integer,Integer> occurenceMap = new HashMap<>();
    int maxOccurence;

    public int getMax(){
        return max;
    }

    public int getMin(){
        return min;
    }

    public float getMean(){
        return mean;
    }

    public void insert(int temperature){
        if(max<temperature){
            max=temperature;
        }
        if(min>temperature){
            min=temperature;
        }
        totalNumber++;
        totalSum+=temperature;
        mean = totalSum/totalNumber;
        int value =0;
        if(occurenceMap.containsKey(temperature)){
            value = occurenceMap.get(temperature);
            occurenceMap.put(temperature,value++);
        }else{
            value=1;
            occurenceMap.put(temperature,value);
        }
        maxOccurence = value>maxOccurence?temperature:maxOccurence;

    }

    public int getMode(){
        return maxOccurence;
    }


    public static void main(String[] args){
        TemperatureData t = new TemperatureData();
        t.insert(10);
        t.insert(10);
        t.insert(50);
        t.insert(5);
        t.insert(55);
        t.insert(50);
        System.out.println("Max : "+t.getMax());
        System.out.println("Min : "+t.getMin());
        System.out.println("Mean : "+t.getMean());
        System.out.println("Mode : "+t.getMode());



    }
}
