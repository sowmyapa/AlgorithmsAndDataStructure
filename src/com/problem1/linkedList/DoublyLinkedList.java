package com.problem1.linkedList;

/**
 * Created by sowmyaparameshwara on 3/30/17.
 */
public class DoublyLinkedList {

    Node head;
    int count;

    class Node{
        int value;
        Node next;
        Node prev;

        Node(int value,Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }




    public static void main(String[] args){

        DoublyLinkedList dl = new DoublyLinkedList();
        dl.add(5);
        dl.add(7);
        dl.add(6,1);
        dl.insertAtBeginning(4);
        dl.removeByValue(5);
        dl.removeAtIndex(1);
        dl.removeAtBeginning();
        dl.removeAtEnd();

        dl.print();


    }

    private void removeAtEnd() {
        Node temp = head;
        while(temp!=null && temp.next!=null){
            temp=temp.next;
        }
        if(temp!=null & temp.prev!=null){
            temp.prev.next = null;
        }else{
            head=null;
        }
    }

    private void removeAtBeginning() {
        Node temp = head;
        if(temp!=null){
            head=temp.next;
            head.prev=null;
        }
    }

    private void removeAtIndex(int index) {
        if(index>=count){
            System.out.println("Invalid index");
        }else{
            count--;
            int pos=0;
            Node temp =head;
            while(temp.next!=null && pos!=index){
                pos++;
                temp=temp.next;
            }
            count--;
            if(temp.prev!=null) {
                temp.prev.next = temp.next;
            }
            if(temp.next!=null) {
                temp.next.prev = temp.prev;
            }


        }

    }

    private void removeByValue(int value) {
        Node temp = head;
        while(temp!=null && temp.value!=value){
            temp = temp.next;
        }
        if(temp!=null){
            count--;
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
        }
    }

    private void insertAtBeginning(int value) {
        Node node = new Node(value,null,null);
        count++;
        Node temp =head;
        node.next=temp;
        if(temp!=null){
            temp.prev = node;
        }
        head = node;

    }

    private void add(int value, int index) {
     if(index>count){
         System.out.println("Invalid index");
     }else if(count==index){
         add(value);
        }else{
                Node node = new Node(value,null,null);

                count++;
                int pos=0;
                Node temp =head;
                while(temp.next!=null && pos+1!=index){
                    pos++;
                    temp=temp.next;
                }
                Node newNext = temp.next;
                temp.next=node;
                node.prev=temp;
                node.next =newNext;
                if(newNext!=null){
                    newNext.prev=temp;
                }

            }

    }

    private void print() {
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    private void add(int value) {
        Node node = new Node(value,null,null);
        count++;
        if (head == null) {
            head=node;
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
            node.prev=temp;
        }
    }
}
