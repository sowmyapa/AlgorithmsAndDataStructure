package com.problem1.tree;

/**
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 */
public class ConstructBinaryTree2 {

    int pIndex;

    public static void main(String[] args) {
        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        ConstructBinaryTree2 binaryTree2 = new ConstructBinaryTree2();
        binaryTree2.pIndex = in.length - 1;
        Node node = binaryTree2.constructTree(in, post, 0, in.length - 1);
        binaryTree2.preOrder(node);
    }

    private void preOrder(Node node) {
        if(node==null)
            return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    private Node constructTree(int[] in, int[] post, int start, int end) {
        if (start > end)
            return null;
        Node newNode = new Node(post[pIndex--]);
        if(start==end)
            return newNode;
        int inIndex = search(in, (Integer) newNode.data,start,end);
        newNode.right = constructTree(in,post,inIndex+1,end);
        newNode.left = constructTree(in,post,start,inIndex-1);
        return newNode;
    }

    private int search(int[] in, int data, int start, int end) {
        int i;
        for(i=start;i<=end;i++){
           if(in[i]==data){
               return i;
           }
        }
        return i;
    }
}

