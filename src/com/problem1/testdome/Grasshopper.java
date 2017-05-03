package com.problem1.testdome;

import java.util.Arrays;

public class Grasshopper {

    boolean visited[];
    int curPosition;
    int n;
    /**
     * Initialization of view field with n leaves and grasshopper on leaf 'position'.
     *
     * @param n Number of leaves in row.
     * @param position
     */
    public Grasshopper(int n, int position) {
        this.n = n;
        visited = new boolean[n];
        Arrays.fill(visited,false);
        this.curPosition = position-1;
    }

    /**
     * Grasshopper has eaten the current leaf and hopped left.
     */
    public void eatAndHopLeft() {
        visited[curPosition]=true;
        int numberOfMoves=2;
        while(numberOfMoves>0){
            --curPosition;
            if(!visited[curPosition]){
                numberOfMoves--;
            }
        }
    }


    /**
     * Grasshopper has eaten the current leaf and hopped right.
     */
    public void eatAndHopRight() {
        visited[curPosition]=true;
        int numberOfMoves=2;
        while(numberOfMoves>0){
            curPosition++;
            if(!visited[curPosition]){
                numberOfMoves--;
            }
        }
    }

    /**
     * Return the leaf number that grasshopper is feeding on right now.
     *
     * @return Leaf number that grasshopper is feeding on right now.
     */
    public int whereAmI() {
        return curPosition+1;
    }

    public static void main(String[] args) {
        Grasshopper1 g = new Grasshopper1(100, 3);
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
        g.print();
    }

}