package com.problem1.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/bfsshortreach/problem
 */
public class ShortestSearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            LinkedList<Integer>[] adjList = new LinkedList[n+1];
            for(int i=0;i<=n;i++){
                adjList[i] = new LinkedList();
            }
            int m = in.nextInt();
            for(int a1 = 0; a1 < m; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                adjList[u].add(v);
                adjList[v].add(u);
            }

            int s = in.nextInt();
            dijkshtras(s,adjList);
        }
        in.close();
    }

    static void dijkshtras(int s, LinkedList<Integer>[] adjList){
        boolean[] visited = new boolean[adjList.length];
        int[] distances = new int[adjList.length];
        Arrays.fill(distances,-1);
        distances[s] = 0;
        for(int i=1;i<adjList.length;i++){
            int u = findMinVertex(distances,visited);
            if(u==-1)
                break;
            visited[u] = true;
            Iterator<Integer> neighbours = adjList[u].listIterator();
            while(neighbours.hasNext()){
                int n = neighbours.next();
                //System.out.println("n "+n+ " u "+u+" !visited[n] "+!visited[n]+"  distances[n] "+distances[n]+" distances[u] "+distances[u]);
                if(!visited[n] && (distances[n]==-1 || distances[n]>distances[u]+6)){
                    distances[n]=distances[u]+6;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        int i =1;
        for(i=1; i<distances.length;i++){
            if(i==s)
                continue;
            result.append(distances[i]+" ");
        }
        System.out.println(result.toString());
    }

    static int findMinVertex(int[] distances,boolean[] visited){
        int minIndex=-1;
        int min = Integer.MAX_VALUE;
        for(int i=1;i < distances.length;i++){
            if(!visited[i] && distances[i]!=-1 && distances[i]<min){
                minIndex = i;
                min = distances[i];
            }
        }
        return minIndex;
    }
}

