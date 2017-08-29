package com.problem1.tree;

import com.problem1.StringPermutation;

/**
 * http://www.geeksforgeeks.org/evaluation-of-expression-tree/
 */
public class EvaluateExpressionTree {

    public static void main(String[] args) {
        // create a syntax tree
        Node<String> root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node<String>("5");
        root.left.right = new Node<String>("4");
        root.right = new Node<String>("-");
        root.right.left = new Node<String>("100");
        root.right.right = new Node<String>("20");
        System.out.println(" Result: "+eval(root));

        root = new Node<String>("+");
        root.left = new Node<String>("*");
        root.left.left = new Node<String>("5");
        root.left.right = new Node<String>("4");
        root.right = new Node<String>("-");
        root.right.left = new Node<String>("100");
        root.right.right = new Node<String>("/");
        root.right.right.left = new Node<String>("20");
        root.right.right.right = new Node<String>("2");

        System.out.println(" Result: "+eval(root));
    }

    private static int eval(Node<String> root) {
        if(root==null)
            return 0;
        if(root.left == null && root.right == null)
            return Integer.parseInt(root.data);
        int lval = eval(root.left);
        int rval = eval(root.right);

        if(root.data=="+")
            return lval+rval;
        else if(root.data=="-")
            return  lval-rval;
        else if(root.data=="*")
            return lval*rval;
        else
            return lval/rval;
    }
}
