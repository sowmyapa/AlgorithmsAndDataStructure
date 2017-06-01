package com.problem1.testdome;

import java.math.BigInteger;
import java.util.*;

public class Sum3 {

    ArrayList<Integer> elements;

    TreeMap<BigInteger,Integer> sum3;

    Sum3(){
        elements = new ArrayList<>();
        sum3 = new TreeMap<>();
    }
    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void addLast(int[] list) {
        BigInteger runningCount= BigInteger.valueOf(0);

        for(int i=0;i<list.length && i<2;i++) {
            int size = elements.size();
            if(i==0 && size>2){
                BigInteger temp = BigInteger.valueOf(elements.get(size-1));
                temp=temp.add(BigInteger.valueOf(elements.get(size-2)));
                temp=temp.add(BigInteger.valueOf(list[0]));
                sum3.put(temp,1);
            }else if(i==1 && size>2){
                sum3.put(BigInteger.valueOf(elements.get(size-1)+list[0]+list[1]),1);

            }
            elements.add(list[i]);
            runningCount.add(BigInteger.valueOf(list[i]));
        }
        for(int i=2;i<list.length;i++){
            runningCount.add(BigInteger.valueOf(list[i]));
            if(i>2){
                runningCount.subtract(BigInteger.valueOf(list[i-3]));

            }
            elements.add(list[i]);

           // if(list.length-i>1) {
                sum3.put(runningCount, 1);
            //}
        }
    }

    public void printSum(){
        Iterator<Map.Entry<BigInteger, Integer>> it = sum3.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<BigInteger, Integer> entry = it.next();
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given sum.
     */
    public boolean containsSum3(BigInteger sum) {

        return sum3.containsKey(sum);
    }

    public static void main(String[] args) {
        Sum3 s = new Sum3();

        int[] hundre = new int[1];
        for(int i=0;i<1;i++){
            hundre[i]=i;
        }
        s.addLast(hundre);

        System.out.println(s.containsSum3(BigInteger.valueOf(6)));
        System.out.println(s.containsSum3(BigInteger.valueOf(150)));

        s.addLast(new int[] { 5 });
        s.addLast(new int[] { 6 });
        s.addLast(new int[] { 7 });
        s.addLast(new int[] { 8 });
        s.addLast(new int[] { 9 });
        s.addLast(new int[] { 10 });

        System.out.println(s.containsSum3(BigInteger.valueOf(11)));
        //s.printSum();;
    }
}