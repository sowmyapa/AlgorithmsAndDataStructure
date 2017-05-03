package com.problem1.testdome;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Snapshot {
    private ArrayList<Integer> data;

    public Snapshot(ArrayList<Integer> data)
    {
        this.data = new ArrayList<>(Collections.unmodifiableCollection(data));
    }

    public ArrayList<Integer> restore()
    {
        //return this.data;
        List<Integer> unmodifiableList =Collections.unmodifiableList(this.data);
        return  new ArrayList<>(Collections.unmodifiableCollection(this.data));
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        Snapshot snap = new Snapshot(list);
        list.set(0, 3);
        list = snap.restore();
        System.out.println(list); // Should output [1, 2]
        list.add(4);
        list = snap.restore();
        System.out.println(list); // Should output [1, 2]
    }
}