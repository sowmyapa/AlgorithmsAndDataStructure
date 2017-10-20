/*
package com.problem1;

*/
/**
 * Created by sowmyaparameshwara on 10/2/17.
 *//*

public class RefDash {
    */
/*
            1
       2              3
    4    5         6
  8  9           12  13

[1, 2, 4, 8, 9, 10, 11, 12, 13, 14, 15, 7, 3, 1]


*//*


    public List<Node> antiClockwiseTraversal(Node root){
        List<Integer> resultList = new ArrayList<Integer>();
        if(root==null)
            return;
        Node temp = root;
        resultList.add(root.value);
        while(temp.left!=null ){
            resultList.add(temp.left.value);
            temp = temp.left;
        }

        printLeaves(root,resultList);
        temp = root;
        while(temp.right!=null){
            resultList.add(temp.right.value);
            temp = temp.right;
        }
        return resultList;
    }

    private void printLeaves(Node temp, List<Integer> resultList){
        if(temp==null)
            return;
        if(temp.leftChild ==null && temp.rightChild==null){
            resultList.add(temp.value);
        }else{
            printLeaves(temp.leftChild);
            printLeaves(temp.rightChild);
        }
    }







*/
/*
[1, 3, 2, 0, 4, 2, 1, 4, 4]



*//*

import java.util.*;

    public int maxIndex(int[] arr){
        int maxElement=0;
        int totalMax=0;
        for(int a : arr){
            if(a >maxElement){
                maxElement = a;
                totalMax=1;
            }else if(a==maxElement) {
                maxElement = a;
                totalMax++;
            }
        }

        int result=0;
        // [0, 1) <- Math.random() <= 1/weight
        // Reservoir sampling
        int occurences=1;
        for(int i=0; i<arr.length;i++){
            if(a==maxElement){
                occurences++;
                int r = Math.random();
                result = (r<=(occurences-1)/occurences)?:result:i;
            }
        }
        return result;
    }




//0.1, 0.2, 0.3, 0.25, 0.9






}
*/
