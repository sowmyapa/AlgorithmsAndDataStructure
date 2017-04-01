package com.problem1.graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sowmyaparameshwara on 3/10/17.
 *
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 *
 *
 */
public class BFSGraphs {

    private static class Graph{
        int numberOfVertices;
        LinkedList<Integer>[] adjList;

        Graph(int numberOfVertices){
            this.numberOfVertices = numberOfVertices;
            adjList = new LinkedList[numberOfVertices];
            for(int i=0;i<numberOfVertices;i++){
                adjList[i] = new LinkedList<Integer>();
            }

        }

        public void addEdge(int v,int w){
            adjList[v].add(w);

        }

        public void bfs(int start) {
            boolean[] vistied=new boolean[numberOfVertices];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            vistied[start]=true;
            queue.add(start);
            while (!queue.isEmpty()){
                int s = queue.poll();
                System.out.println(" "+s);
                Iterator<Integer> iterator = adjList[s].listIterator();
                while (iterator.hasNext()){
                    int n = iterator.next();
                    if(!vistied[n]){
                        vistied[n] = true;
                        queue.add(n);
                    }

                }
            }

        }

        private void traverse(int start, boolean[] vistied) {
            vistied[start]=true;
            System.out.println(start);
            Iterator<Integer> it = adjList[start].listIterator();
            while(it.hasNext()){
                int next = it.next();
                if(!vistied[next]){
                    traverse(next,vistied);
                }
            }
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(2);

    }
}


