package com.problem1.testdome;

import java.util.*;

public class Sum3 {

    ArrayList<Integer> elements;

    TreeMap<Integer,Integer> sum3;

    Sum3(){
        elements = new ArrayList<>();
        sum3 = new TreeMap<>();
    }
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void addLast(int[] list) {
        int runningCount=0;

        for(int i=0;i<list.length && i<2;i++) {
            int size = elements.size();
            if(i==0 && size>2){
                sum3.put(elements.get(size-1)+elements.get(size-2)+list[0],1);
            }else if(i==1 && size>2){
                sum3.put(elements.get(size-1)+list[0]+list[1],1);

            }
            elements.add(list[i]);
            runningCount+=list[i];
        }
        for(int i=2;i<list.length;i++){
            runningCount+=list[i];
            if(i>2){
                runningCount-=list[i-3];
            }
            elements.add(list[i]);
            if(i==97){
                System.out.println();;
            }
           // if(list.length-i>1) {
                sum3.put(runningCount, 1);
            //}
        }
    }

    public void printSum(){
        Iterator<Map.Entry<Integer, Integer>> it = sum3.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Integer> entry = it.next();
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given sum.
     */
    public boolean containsSum3(int sum) {

        return sum3.containsKey(sum);
    }

    public static void main(String[] args) {
        Sum3 s = new Sum3();

        int[] hundre = new int[100];
        for(int i=0;i<100;i++){
            hundre[i]=i;
        }
        s.addLast(hundre);

        System.out.println(s.containsSum3(6));
        System.out.println(s.containsSum3(150));

        s.addLast(new int[] { 4 });
        s.addLast(new int[] { 4 });
        s.addLast(new int[] { 4 });
        s.addLast(new int[] { 4 });
        s.addLast(new int[] { 4 });
        s.addLast(new int[] { 4 });



        System.out.println(s.containsSum3(11));
        //s.printSum();;
    }
}