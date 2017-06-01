package com.problem1.testdome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sowmyaparameshwara on 5/5/17.
 */
public class Grasshopper2 {

    class Node{
        boolean value;
        int position;
        Node left;
        Node right;
    }

    int total=0;
    List<Node> leaves;
    Node curNode=null;


    /**
     * Initialization of view field with n leaves and grasshopper on leaf 'position'.
     *
     * @param n Number of leaves in row.
     * @param position
     */
    public Grasshopper2(int n, int position) {

        this.total = n;
        leaves = new ArrayList<Node>(n);
        for(int i=0;i<n;i++){
            Node temp= new Node();
            temp.value=true;
            temp.position=i;
            if(i==0) {
                temp.left = null;
            }else if(i==n-1){
                temp.right = null;
            }else{
                temp.left = leaves.get(i-1);
                temp.left.right = temp;
            }
            leaves.add(temp);

        }
        curNode = leaves.get(position-1);
        //mark();
    }

    private void mark() {
        curNode.value=false;
        Node leftTemp = curNode.left;
        if(leftTemp!=null) {
            curNode.left.right = curNode.right;
        }
        if(curNode.right!=null) {
            curNode.right.left = leftTemp;
        }

    }

    /**
     * Grasshopper has eaten the current leaf and hopped left.
     */
    public void eatAndHopLeft() {
        mark();
        curNode = curNode.left.left;

    }


    /**
     * Grasshopper has eaten the current leaf and hopped right.
     */
    public void eatAndHopRight() {
        mark();
        curNode = curNode.right.right;

    }

    public int whereAmI() {
        return curNode.position+1;
    }

    public static void main(String[] args) {
        Grasshopper2 g = new Grasshopper2(5,2);
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopLeft();
        System.out.println(g.whereAmI());

       /* g.eatAndHopRight();
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
        System.out.println(g.whereAmI());*/

        System.out.println(" ------------  ");
        //g.print();
    }


    public void print(){
        for(int i=0;i<total;i++){
            System.out.println("i :"+i+" leave : "+leaves.get(i));
        }
    }
}
