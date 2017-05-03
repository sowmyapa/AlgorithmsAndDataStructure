package com.problem1.testdome;

enum Side { NONE, LEFT, RIGHT }

public class ChainLink {
    private ChainLink left, right;

    public void append(ChainLink rightPart) {
        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");

        this.right = rightPart;
        rightPart.left = this;
    }

    public Side longerSide() {
        ChainLink original = this;
        ChainLink temp = original;
        int leftcount=0,rightCount=0;
        if(checkForLoop(original)) {
            return Side.NONE;
        }
        while(temp.left!=null){
            temp=temp.left;
            leftcount++;
        }
        temp = original;
        while(temp.right!=null){
            temp=temp.right;
            rightCount++;
        }
        if(rightCount>leftcount){
            return Side.RIGHT;
        }else if(rightCount<leftcount){
            return Side.LEFT;
        }else{
            return Side.NONE;
        }
    }

    private boolean checkForLoop(ChainLink original) {
        ChainLink fast = original;
        ChainLink slow=original;
        while(slow!=null && fast!=null && fast.right!=null){
            slow=slow.right;
            fast=fast.right.right;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);

        System.out.println(left.longerSide());
    }
}