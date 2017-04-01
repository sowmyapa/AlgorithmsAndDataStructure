package com.problem1.graphs;

import java.util.*;

/**
 * Created by sowmyaparameshwara on 3/11/17.
 */
public class DijkshtrasPrirotiyQueue {


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

    static class Node{
        int distance;
        int index;

        Node(int distance,int index){
            this.distance = distance;
            this.index = index;
        }

    }

    private static void shortestPath(int[][] graph, int src) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>(){

            @Override
            public int compare(Node o1, Node o2) {
                return o1.distance-o2.distance;
            }
        });
        int noOfVertices = graph.length;
        boolean[] determined = new boolean[noOfVertices];
        int[] parent = new int[noOfVertices];
        int[] distances = new int[noOfVertices];
        Arrays.fill(distances,Integer.MAX_VALUE);
        Arrays.fill(determined,false);
        Arrays.fill(parent,-1);
        List<Node> ref = new ArrayList<Node>();


        distances[src] = 0;
        for(int i=0; i<noOfVertices; i++){
            Node node =new Node(distances[i],i);
            ref.add(node);
            queue.add(node);
        }
        for(int i=0; i<noOfVertices-1; i++){
            int u = queue.poll().index;
            System.out.println(" min : "+u);

            determined[u]=true;
            for(int j=0;j<noOfVertices;j++){
                if(graph[u][j]>0 && determined[j]==false && distances[u]!=Integer.MAX_VALUE
                        && distances[j]>graph[u][j]+distances[u]){
                    distances[j] = graph[u][j]+distances[u];
                    Node node = ref.get(j);
                    queue.remove(ref.get(j));
                    node.distance = distances[j];
                    queue.add(node);
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
