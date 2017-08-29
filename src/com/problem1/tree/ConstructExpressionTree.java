package com.problem1.tree;

import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/expression-tree/
 */
public class ConstructExpressionTree {

    public static void main(String[] args){
        String postfix = "ab+ef*g*-";
        ConstructExpressionTree expressionTree = new ConstructExpressionTree();
        Node root = expressionTree.construct(postfix);
        expressionTree.inorder(root);
    }

    // Utility function to do inorder traversal
    private void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.data + " ");
            inorder(t.right);
        }
    }


    private Node construct(String postfix) {
        Stack<Node> s = new Stack();
        Node temp1,temp2,temp3;
        for(int i=0;i < postfix.length();i++){
            char c = postfix.charAt(i);
            if(isOperator(c)){
                temp2 = s.pop();
                temp3 = s.pop();
                temp1 = new Node(c);
                temp1.right = temp2;
                temp1.left = temp3;
                s.push(temp1);
            }else{
                temp1 = new Node(c);
                s.push(temp1);
            }

        }
        return s.pop();
    }

    private boolean isOperator(char op){
        if(op=='+' || op=='-' || op=='/' || op=='*')
            return true;
        return false;
    }

}

