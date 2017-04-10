package com.problem1.interviewcake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sowmyaparameshwara on 4/9/17.
 * https://www.interviewcake.com/question/java/balanced-binary-tree
 */
public class NodeDepthPair {

    BinaryTreeNode node;
    int depth;

    NodeDepthPair(BinaryTreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }

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
        System.out.println("Enter root node value");
        int value = in.nextInt();
        BinaryTreeNode root = new BinaryTreeNode(value);
        in.nextLine();
        addChildren(in,root);
        boolean res = determineSuperBalance(root,0);
        System.out.println("Result is "+res);
    }

    private static boolean determineSuperBalance(BinaryTreeNode root,int depth) {
        List<Integer> depths = new ArrayList();
        Stack<NodeDepthPair> stack = new Stack();
        stack.push(new NodeDepthPair(root,depth));
        while(!stack.empty()){
            NodeDepthPair temp = stack.pop();
            if(temp.node.left==null && temp.node.right==null){
                int newDepth = temp.depth;
                if(!depths.contains(newDepth)){
                    depths.add(newDepth);
                    if(depths.size()>2 || (depths.size()==2 && (Math.abs(depths.get(0)-depths.get(1))>1))){
                        return false;
                    }
                }
            }else{
                if(temp.node.left!=null){
                    stack.push(new NodeDepthPair(temp.node.left,temp.depth+1));
                }
                if(temp.node.right!=null){
                    stack.push(new NodeDepthPair(temp.node.right,temp.depth+1));
                }
            }
        }
        return true;

    }

    private static void addChildren(Scanner in,BinaryTreeNode node) {
        int value;
        System.out.println("Enter 1 if \""+node.value+"\" has only left node, 2 if tree has right node, 3 if it has both, 4 if it has none");
        int childType = in.nextInt();
        in.nextLine();
        BinaryTreeNode temp1;
        BinaryTreeNode temp2;
        switch(childType){
            case 1: System.out.println("Enter left node value for : "+node.value);
                value = in.nextInt();
                in.nextLine();
                temp1 = node.insertLeft(value);
                addChildren(in,temp1);
                break;
            case 2: System.out.println("Enter right node value"+node.value);
                value = in.nextInt();
                in.nextLine();
                temp1 = node.insertRight(value);
                addChildren(in,temp1);
                break;
            case 3: System.out.println("Enter left and right node value"+node.value);
                value = in.nextInt();
                temp1 = node.insertLeft(value);
                value = in.nextInt();
                temp2 = node.insertRight(value);
                addChildren(in,temp1);
                addChildren(in,temp2);
                break;
        }

    }
}
