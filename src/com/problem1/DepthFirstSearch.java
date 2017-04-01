package com.problem1;

import java.util.Scanner;


/**
 * Time complexity : O(n)
 * Space complexity : O(h)
 *                    Worst : O(n)
 *                    Best/Average : O(log n) 
 * @author sowmyaparameshwara
 *
 */
public class DepthFirstSearch {
	
	static Node root;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		DepthFirstSearch dfs = new DepthFirstSearch();
		  dfs.root = new Node(1);
	        dfs.root.left = new Node(2);
	        dfs.root.right = new Node(3);
	        dfs.root.left.left = new Node(4);
	        dfs.root.left.right = new Node(5);
	        System.out.println("preorder");
	        dfs.preorder(root);
	        System.out.println();
	        System.out.println("inorder");
	        dfs.inorder(root);
	        System.out.println();
	        System.out.println("postorder");
	        dfs.postorder(root);
		
	}

	private void postorder(Node root) {
		if(root == null)
			return;
		if(root.left!=null)
			postorder(root.left);
		if(root.right!=null)
			postorder(root.right);	
		System.out.print(root.value+" ");

	}
	
	
	private void inorder(Node root) {
		if(root == null)
			return;
		if(root.left!=null)
			inorder(root.left);
		System.out.print(root.value+" ");
		if(root.right!=null)
			inorder(root.right);		
	}

	private void preorder(Node root) {
		if(root == null)
			return;
		System.out.print(root.value+" ");
		if(root.left!=null)
			preorder(root.left);
		if(root.right!=null)
			preorder(root.right);
		
	}

}


