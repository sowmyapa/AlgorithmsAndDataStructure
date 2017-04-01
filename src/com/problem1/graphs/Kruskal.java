package com.problem1.graphs;

import java.util.Arrays;

/**
 * Created by sowmyaparameshwara on 3/11/17.
 *
 * Time complexity : O(ELOGE) + O(E)   "ELOGE is for sorting edges and E is for the loop to find minimum tree"
 * Space complexity : O(E+V)
 */
public class Kruskal {

    private static class Graph{

        int v;
        int e;
        Edge[] edges;

        Graph(int v, int e){
            this.v = v;
            this.e = e;
            edges = new Edge[e];
        }

        private void add(int i,Edge edge){
            edges[i] = edge;
        }

        public void kruskal() {
            Edge[] result = new Edge[v-1];
            Arrays.sort(edges);
            Subset[] subsets = new Subset[v];
            for(int i=0;i<v;i++){
                subsets[i] = new Subset(i,0);
            }

            int j=0,k=0;
            while (j < v - 1){
                Edge edge = edges[k++];
                int xroot = Subset.findSubset(subsets,edge.src);
                int yroot = Subset.findSubset(subsets,edge.dest);



                if(xroot!=yroot){
                    result[j++]=edge;
                    Subset.union(subsets,edge.src,edge.dest);
                }
            }

            for(int i=0;i<result.length;i++){
                System.out.println(" Src : "+result[i].src+" Dest : "+result[i].dest+" Weight : "+result[i].weight);
            }

        }

        private static class Edge implements  Comparable<Edge>{
            private int src;
            private int dest;
            private int weight;

            Edge(int src,int dest,int weight){
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }

            @Override
            public int compareTo(Edge o) {
                return this.weight-o.weight;
            }
        }

        private static class Subset{
            int parent;
            int rank;

            Subset(int parent,int rank){
                this.parent = parent;
                this.rank = rank;
            }

            static int findSubset(Subset[] subsets,int i){
                int parent = subsets[i].parent;
                if(i!=parent)
                    findSubset(subsets,parent);
                return subsets[i].parent;
            }

            static void union(Subset[] subsets,int x, int y){
                int xroot = findSubset(subsets,x);
                int yroot = findSubset(subsets,y);

                if(subsets[xroot].rank<subsets[yroot].rank){
                    subsets[xroot].parent=yroot;
                }else if(subsets[xroot].rank>subsets[yroot].rank){
                    subsets[yroot].parent=xroot;
                }else{
                    subsets[xroot].rank++;
                    subsets[yroot].parent=xroot;
                }
            }

        }
    }

    public static void main(String[] args){
        Graph graph = new Graph(4,5);
        graph.add(0,new Graph.Edge(0,1,10));
        graph.add(1,new Graph.Edge(0,2,6));
        graph.add(2,new Graph.Edge(0,3,5));
        graph.add(3,new Graph.Edge(1,3,15));
        graph.add(4,new Graph.Edge(2,3,4));

        graph.kruskal();
    }
}
