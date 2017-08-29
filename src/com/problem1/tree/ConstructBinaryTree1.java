package com.problem1.tree;

import com.problem1.testdome.ChainLink;

/**
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 */
public class ConstructBinaryTree1 {

    int pIndex=0;

    public static void main(String[] args){
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        ConstructBinaryTree1 constructBinaryTree = new ConstructBinaryTree1();
        Node root = constructBinaryTree.constructTree(in,pre,0,in.length-1);
        constructBinaryTree.printInorder(root);
    }

    private void printInorder(Node root) {
        if(root==null)
            return;
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }

    private Node constructTree(char[] in, char[] pre, int start, int end) {
        if(start>end){
            return null;
        }
        Node newNode = new Node<Character>(pre[pIndex++]);
        if(start==end)
            return newNode;
        int inIndex = search(in, (Character) newNode.data,start,end);
        newNode.left = constructTree(in,pre,start,inIndex-1);
        newNode.right=constructTree(in,pre,inIndex+1,end);
        return newNode;
    }

    private int search(char[] in, Character data, int start, int end) {
        int i;
        for(i=start;i<=end;i++){
            if(in[i]==data){
                return i;
            }
        }
        return i;
    }

}

class Node<T>{

    T data;
    Node left, right;

    public Node(T data) {
        this.data = data;
    }
}

