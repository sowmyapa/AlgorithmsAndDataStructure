package com.problem1.testdome;

import java.util.LinkedList;

public class TrainComposition {
    LinkedList<Integer> wagonList = new LinkedList();

    public void attachWagonFromLeft(int wagonId) {
        wagonList.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        wagonList.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        int value = wagonList.removeFirst();
        return value;
    }

    public int detachWagonFromRight() {
        int value = wagonList.removeLast();
        return value;
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}