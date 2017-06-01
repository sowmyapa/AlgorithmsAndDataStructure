package com.problem1.testdome;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by sowmyaparameshwara on 5/3/17.
 */
public class Sum3_2 {

    ArrayList<Integer> elements;
    HashSet<BigInteger> sums;
    BigInteger runningCount=null;

    Sum3_2(){
        elements=new ArrayList();
        sums = new HashSet<>();

    }

    public void addLast(int[] list) {

        for (int i = 0; i < list.length; i++) {
            elements.add(list[i]);
            int currentSize=elements.size();
            if(runningCount== null && currentSize==3){
                BigInteger temp = new BigInteger(String.valueOf(elements.get(0)));
                temp = temp.add(BigInteger.valueOf(elements.get(1)));
                temp = temp.add(BigInteger.valueOf(elements.get(2)));
                sums.add(temp);
                runningCount = temp;
            }else if(currentSize>3){
                runningCount = runningCount.subtract(BigInteger.valueOf(elements.get(currentSize-4)));
                runningCount = runningCount.add(BigInteger.valueOf(elements.get(currentSize-1)));
                sums.add(runningCount);
            }
        }
    }

    public boolean containsSum3(BigInteger sum) {
        return sums.contains(sum);
    }



    public static void main(String[] args) {
        Sum3_2 sum3 = new Sum3_2();
        int[] hundred = new int[1];
        for(int i=0;i<1;i++){
            hundred[i]=i;
        }
        sum3.addLast(hundred);

        System.out.println(sum3.containsSum3(BigInteger.valueOf(6)));
        System.out.println(sum3.containsSum3(BigInteger.valueOf(150)));

        sum3.addLast(new int[] { 5 });
        sum3.addLast(new int[] { 6 });
        sum3.addLast(new int[] { 7 });
        sum3.addLast(new int[] { 8 });
        sum3.addLast(new int[] { 9 });
        sum3.addLast(new int[] { 10 });



        System.out.println(sum3.containsSum3(BigInteger.valueOf(11)));

    }
}
