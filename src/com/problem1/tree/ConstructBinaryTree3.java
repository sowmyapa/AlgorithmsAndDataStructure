package com.problem1.tree;

/**
 * http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
 */
public class ConstructBinaryTree3 {

    static int preIndex=0;

    public static void main(String[] args){

        int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };

        Node root = constructTree(pre, post, 0,pre.length-1,pre.length);

        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }

    private static void printInorder(Node root) {
        if(root==null)
            return;
        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }

    private static Node constructTree(int[] pre, int[] post, int start, int end,int size) {
        if(preIndex>=size || start>end)
            return null;
        Node temp = new Node<Integer>(pre[preIndex++]);
        if(start==end || preIndex>=size)
            return temp;

        int i = search(pre[preIndex],post,start,end);
        if(i<=end) {
            temp.left = constructTree(pre, post, start, i , size);
            temp.right = constructTree(pre, post, i + 1, end, size);
        }
        return temp;
    }

    private static int search(int val, int[] post, int start, int end) {
        int i;
        for(i = start; i<=end; i++){
            if(post[i]==val)
                return i;
        }
        return i;
    }

}
