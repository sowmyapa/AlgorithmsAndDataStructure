package com.problem1.graphs;

import java.util.LinkedList;

/**
 * Created by sowmyaparameshwara on 3/11/17.
 *
 * https://www.hackerearth.com/practice/notes/heaps-and-priority-queues/
 *
 * We can use heaps to implement the priority queue. It will take O(log N) time to insert and delete each element in the priority queue.
 *
 * Maximum : Complexity: O(1)
 *
 * Extract Maximum: Complexity: O(logN).
 *
 * Increase Value: Complexity : O(log N).
 *
 * Insert Value : Complexity: O(log N).
 */
public class CustomPriorityQueue {

    LinkedList<Integer> queue = new LinkedList<Integer>();
    int length=0;

    private void insertValue(int val){
        length+=1;
        queue.add(-1);
        increaseValue(val,length-1);

    }

    private void increaseValue(int val, int index) {
        queue.set(index,val);
        while(index>0 && queue.get(index/2)<queue.get(index)){
             int temp = queue.get(index/2);
            queue.set(index/2,queue.get(index));
            queue.set(index,temp);
            index=index/2;
        }
    }


    private int getMaximum(){
        return queue.get(0);
    }

    private int extractMaximum(){
        int max=queue.get(0);
        int temp =queue.get(0);
        queue.set(0,queue.get(length-1));
        queue.set(length-1,temp);
        length--;
        heapify(0);

        return max;
    }

    private void heapify(int i) {
        int l = 2*i;
        int r =2*i+1;
        int max=i;
        if(l<length && queue.get(l)>queue.get(max))
            max=l;
        if(r<length && queue.get(r)>queue.get(max))
            max=r;
        if(max!=i){
            int temp = queue.get(max);
            queue.set(max,queue.get(i));
            queue.set(i,temp);
            heapify(max);
        }

    }

    public static void main(String[] args){
          CustomPriorityQueue q = new CustomPriorityQueue();
        q.insertValue(5);
        q.insertValue(3);
        q.insertValue(1);
        q.insertValue(8);
        q.insertValue(0);

        System.out.println(q.extractMaximum());
        System.out.println(q.extractMaximum());

        System.out.println(q.extractMaximum());

        System.out.println(q.extractMaximum());

        System.out.println(q.extractMaximum());


    }
}
