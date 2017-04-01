package com.problem1.graphs;

import java.util.Arrays;

/**
 * Created by sowmyaparameshwara on 3/10/17.
 *
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 *
 * The complexity of this algorithm is O(|V|^2)
 * If the graph is represented using adjacency list and if we use binary heap, then complexity reduces to 0(ElogV).
 *
 * Dijkstra’s algorithm doesn’t work for graphs with negative weight edges. For graphs with negative weight edges, Bellman–Ford algorithm can be used.
 * The code calculates shortest distance, but doesn’t calculate the path information. We can create a parent array, update the parent array when distance is updated (like prim’s implementation) and use it show the shortest path from source to different vertices.

 2) The code is for undirected graph, same dijkstra function can be used for directed graphs also.

 3) The code finds shortest distances from source to all vertices. If we are interested only in shortest distance from source to a single target, we can break the for loop when the picked minimum distance vertex is equal to target (Step 3.a of algorithm).
 *
 *
 *
 *
 *
 *
 *
 * Things to see :  adjacency list for dijkshtra's
 *
 */
public class Dijkshtras {


    public static void main(String[] args){
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        shortestPath(graph,0);
    }

    private static void shortestPath(int[][] graph, int src) {
        int noOfVertices = graph.length;
       boolean[] determined = new boolean[noOfVertices];
        int[] parent = new int[noOfVertices];
       int[] distances = new int[noOfVertices];
        Arrays.fill(distances,Integer.MAX_VALUE);
        Arrays.fill(determined,false);
        Arrays.fill(parent,-1);

        distances[src] = 0;
        for(int i=0; i<noOfVertices-1; i++){
            int u = findMinVertice(determined,distances);
            System.out.println(" min : "+u);

            determined[u]=true;
            for(int j=0;j<noOfVertices;j++){
                if(graph[u][j]>0 && determined[j]==false && distances[u]!=Integer.MAX_VALUE
                        && distances[j]>graph[u][j]+distances[u]){
                    distances[j] = graph[u][j]+distances[u];
                    parent[j] = u;

                }
            }
        }
        printSolution(distances,parent,src);
    }

    private static void printSolution(int[] distances, int[] parent,int src) {
        for(int i=0;i<distances.length;i++){
            System.out.println(" Shortest distance to "+i+" is "+distances[i]);
            System.out.print(" Path : "+src);

            printPath(parent,i);
            System.out.println();
        }

    }

    private static void printPath(int[] parent,int i) {
        if(parent[i]==-1)
            return;
        printPath(parent,parent[i]);
        System.out.print(" "+i);
    }

    private static int findMinVertice(boolean[] determined, int[] distances) {
        int minIndex=-1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<distances.length;i++){
            if(determined[i]==false && distances[i]<min){
                min=distances[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

}
