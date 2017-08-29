package com.problem1.graphs;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 * The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph.
 */
public class FloydWarshall {

    public static void main(String[] args){
        int graph[][] = { {0,   5,  Integer.MAX_VALUE, 10},
                {Integer.MAX_VALUE, 0,   3, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,   1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        FloydWarshall a = new FloydWarshall();

        // Print the solution
        a.floydWarshall(graph);


    }

    private void floydWarshall(int[][] graph) {
        int v = graph.length;
        int dist[][] = new int[v][v];
        for(int i=0;i<v;i++) {
            dist[i]= Arrays.copyOf(graph[i],v);
        }
        for(int k=0;k<v;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE
                            && dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }

    private void printSolution(int[][] dist) {
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist[i].length;j++){
                if(dist[i][j]==Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+" ");

            }
            System.out.println("");
        }
    }
}
