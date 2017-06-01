package com.problem1.testdome;

import com.problem1.linkedList.DoublyLinkedList;

import java.util.ArrayList;

/**
 * Created by sowmyaparameshwara on 5/5/17.
 */
public class Grasshopper3 {

    DoublyLinkedList list;
    int total;
    DoublyLinkedList.Node curPosition;

    public Grasshopper3(int n, int position) {

        this.total = n;
        list = new DoublyLinkedList();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        this.curPosition = list.retrieveByIndex(position);
    }

    /**
     * Grasshopper has eaten the current leaf and hopped left.
     */
    public void eatAndHopLeft() {
        list.removeByValue(curPosition.value);
        curPosition=curPosition.prev.prev;

    }

    /**
     * Grasshopper has eaten the current leaf and hopped right.
     */
    public void eatAndHopRight() {
        list.removeByValue(curPosition.value);
        curPosition = curPosition.next.next;

    }

    /**
     *
     * 3
     5
     2
     6
     8
     10
     7
     1
     9

     * @return
     */
    public int whereAmI() {
        return curPosition.value+1;
    }

    public static void main(String[] args) {
        Grasshopper3 g = new Grasshopper3(100,3);
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopLeft();
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopLeft();
        System.out.println(g.whereAmI());

        g.eatAndHopLeft();
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        System.out.println(" ------------  ");
        //g.print();
    }
}
