package com.problem1.hackerrank;

/**
 * Created by sowmyaparameshwara on 5/28/17.
 */
public final class Test4 {
 class Inner{
     void test(){
         if(Test4.this.flag){
             sample();
         }
     }
 }
    private boolean flag=true;
    public void sample(){
        System.out.println("Hello");
    }

    public Test4(){
        (new Inner()).test();
    }

    public static void main(String[] args){
        new Test4();
    }
}
