package com.problem1.linkedList;

/**
 * Created by sowmyaparameshwara on 3/9/17.
 */
public class PrintList {

    public static void main(String[] args){
        //Node head=new Node()
    }

    class Node {
        int data;
        Node next;
    }

    void Print(Node head) {
        if (head == null)
            return;
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
