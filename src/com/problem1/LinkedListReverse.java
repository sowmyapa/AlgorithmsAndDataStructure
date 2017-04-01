package com.problem1;

import java.util.Scanner;


public class LinkedListReverse {
	

class ListNode {
    int data;
    ListNode next;
    ListNode prev;
 }
	
	ListNode head;
	
	public static void main(String[] args){
	     LinkedListReverse ll = new LinkedListReverse();
	     ll.head = ll.new ListNode();
	     Scanner in = new Scanner(System.in);
         System.out.println("Enter number of nodes");
         int n = in.nextInt();
         ListNode prev=null;
         for(int i=0;i<n;i++){
        	 int value = in.nextInt();
        	 if(i==0){
        		 prev = ll.head;
        		 ll.head.data=value;
        		 ll.head.next=ll.head.prev=null;
        	 }else{
        		 ListNode temp = ll.new ListNode();
        		 prev.next = temp;
        		 temp.data = value;
        		 temp.next = null;
        		 temp.prev = prev;
        		 prev=temp;
        		 
        	 }
        	 
         }
        ll.printList(ll.head);
        ll.head = ll.Reverse(ll.head);
        ll.printList(ll.head);
	}
	
	void printList(ListNode head){
	     
        System.out.println("List values are : ");
        ListNode temp = head;
        while(temp!=null){
       	 System.out.print(" "+temp.data);
       	 temp=temp.next;
        }
	}

	ListNode Reverse(ListNode head) {
	    if(head==null)
	    	return null;
	    ListNode temp=head;
	    ListNode temp1=head.prev;
	    while(temp!=null){
	    	temp1 = temp.prev;
	    	temp.prev = temp.next;
	    	temp.next = temp1;
	    	temp = temp.prev;
	    }	    
	    return temp1.prev;

	}
}
