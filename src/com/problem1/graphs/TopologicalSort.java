package com.problem1.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/topological-sorting/
 */
public class TopologicalSort {

    private int numberOfVertices;

    private LinkedList<Integer>[] adjList;

    TopologicalSort(int numberOfVertices){
        this.numberOfVertices = numberOfVertices;
        this.adjList = new LinkedList[numberOfVertices];
        for(int i=0; i < numberOfVertices; i++){
            this.adjList[i] = new LinkedList<Integer>();
        }
    }

    public static void main(String[] args){
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }

    private void topologicalSort() {
        boolean[] visited = new boolean[numberOfVertices];
        Stack s = new Stack();
        for(int i = 0; i < visited.length; i++){
            if(!visited[i])
                topologicalSortTraverse(visited,i,s);
        }
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }

    private void topologicalSortTraverse(boolean[] visited, int vertex, Stack s) {
        visited[vertex] = true;
        Iterator<Integer> it = adjList[vertex].iterator();
        while(it.hasNext()){
            Integer adjacentVertex = it.next();
            if(!visited[adjacentVertex])
                topologicalSortTraverse(visited,adjacentVertex,s);
        }
        s.push(vertex);
    }

    private void addEdge(int startVertex, int endVertex) {
        this.adjList[startVertex].add(endVertex);
    }

}
