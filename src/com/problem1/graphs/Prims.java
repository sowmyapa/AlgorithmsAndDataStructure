package com.problem1.graphs;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by sowmyaparameshwara on 3/11/17.
 *
 * http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
 *
 * Time complexity : O( (\V\+\E\)*LOG\V\))
 *                   if binary heap is sed
 *                   if fibonnaci head is used : O(|V|LOG\V\ + \E\)
 */
public class Prims {


    private static class Graph{



        public void primMST(int[][] graph) {
            int v = graph.length;
            int[] parent = new int[v];
            boolean[] included = new boolean[v];
            int[] distance = new int[v];
            Arrays.fill(parent,-1);
            Arrays.fill(distance,Integer.MAX_VALUE);

            distance[0]=0;
            parent[0] = -1;
            for(int i=0;i<v;i++){
                int u = findMinimum(distance,included);
                included[u]=true;
                for(int j=0;j<v;j++){
                    if(!included[j] && graph[u][j]>0 && graph[u][j]<distance[j]){
                        distance[j]=graph[u][j];
                        parent[j]=u;
                    }
                }
            }

            for(int i=1;i<v;i++){
                System.out.println("Edge "+parent[i]+"-"+i+" Weight "+distance[i]);
            }

        }

        private int findMinimum(int[] distance, boolean[] included) {
            int minIndex=-1;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<distance.length;i++){
                if(!included[i] && distance[i]<min){
                    min = distance[i];
                    minIndex=i;
                }
            }
            return minIndex;
        }
    }

    public static void main (String[] args)
    {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
        Graph g = new Graph();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        // Print the solution
        g.primMST(graph);
    }
}
