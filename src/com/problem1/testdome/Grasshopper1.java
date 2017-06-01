package com.problem1.testdome;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grasshopper1 {


    LinkedList list;
    ArrayList<Integer> leaves;
    int curPosition;
    int n;
    /**
     * Initialization of view field with n leaves and grasshopper on leaf 'position'.
     *
     * @param n Number of leaves in row.
     * @param position
     */
    public Grasshopper1(int n, int position) {

        this.n = n;
        leaves = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            leaves.add(i+1);
        }
        this.curPosition = position-1;
    }

    public void print(){
        for(int i=0;i<n;i++){
            System.out.println("i :"+i+" leave : "+leaves.get(i));
        }
    }

    /**
     * Grasshopper has eaten the current leaf and hopped left.
     */
    public void eatAndHopLeft() {
        int oldPosition=curPosition;
        curPosition=curPosition-2;
        leaves.remove(oldPosition);

    }


    /**
     * Grasshopper has eaten the current leaf and hopped right.
     */
    public void eatAndHopRight() {
        int oldPosition=curPosition;
        curPosition=curPosition+2;
        leaves.remove(oldPosition);
    }

    /**
     * Return the leaf number that grasshopper is feeding on right now.
     *
     * @return Leaf number that grasshopper is feeding on right now.
     */
    public int whereAmI() {
        return leaves.get(curPosition);
    }

    public static void main(String[] args) {
        Grasshopper1 g = new Grasshopper1(5, 2);
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopLeft();
        System.out.println(g.whereAmI());

        /*g.eatAndHopRight();
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

        System.out.println(" ------------  ");*/
        //g.print();

    }


















}