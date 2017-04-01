package com.problem1;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Time complexity : Always O(n)
 * Space complexity : Best : O(1), Average/Worst : O(n)
 * @author sowmyaparameshwara
 *
 */
public class LevelOrderTreeTraversal {
	
	Node root;

	public void printLevelOrder() {
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()){
			Node node = queue.poll();
			System.out.print(node.value+" ");
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
			
		}
	}

	public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
		LevelOrderTreeTraversal tree_level = new LevelOrderTreeTraversal();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}

class Node{
	int value;
	Node right,left;
	
	Node(int value){
		this.value = value;
	}
}
