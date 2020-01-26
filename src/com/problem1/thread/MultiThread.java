package com.problem1.testdome;

/**
 * Created by sowmyaparameshwara on 5/7/17.
 */
public class MultiThread {

    public static void main(String[] args) throws InterruptedException {
        Runner r = new Runner();
        Thread thread1 = new Thread(r,"1");
        Thread thread2 = new Thread(r,"2");
        Thread thread3 = new Thread(r,"3");

        thread3.start();
        thread1.start();

        thread3.join();
        System.out.println("Join");
        thread2.start();
        thread1.join();

        thread2.join();
    }


    public static class Runner implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId()+"  "+Thread.currentThread().getName());
        }
    }
}
