package com.problem1.interviewcake;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/9/17.
 */
public class ValidBinarySearchTree {

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numberOfNodes = in.nextInt();
        in.nextLine();
        int[] treeArr = new int[numberOfNodes];
        for(int i=0;i<numberOfNodes;i++){
            treeArr[i] = in.nextInt();
        }
        in.nextLine();
        BinaryTreeNode root = new BinaryTreeNode(treeArr[0]);
        createTree(root,treeArr,0);
        boolean res = isBinarySearch(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println(res);
    }

    private static boolean isBinarySearch(BinaryTreeNode node,int lowerBound,int upperBound) {
        if(node==null || node.value==-1)
            return true;

        if(node.value <= lowerBound || node.value>=upperBound){
            return false;
        }
        return isBinarySearch(node.left,lowerBound,node.value) &&
                isBinarySearch(node.right,node.value,upperBound);
    }

    private static void createTree(BinaryTreeNode node, int[] treeArr, int i) {
        if((2*i + 2) < treeArr.length) {
            BinaryTreeNode temp1 = node.insertLeft(treeArr[(2 * i) + 1]);
            BinaryTreeNode temp2 = node.insertRight(treeArr[(2 * i) + 2]);
            createTree(temp1, treeArr, (2 * i) + 1);
            createTree(temp2, treeArr, (2 * i) + 2);
        }
    }

}
