package com.problem1.graphs;

/**
 * A graph where edges have direction is called directed graph or diagraph.
 * A graph where edges do not have direction is called undirected graph.
 * An edge can or cannot have weight. If the edges have weight graph is called weighted graph.
 * If the edges do not have weight it is called unweighted graph.
 * 
 * if number of vertices is |v|=n, then in directed graph 0<=|E|<=n*(n-1)
 * in undirected graph 0<=|E|<=n*(n-1)/2
 * Therefore number of edges is almost O(n^2)
 * 
 * Walk : is a sequence of vertices where each adjacent pair is connected by an edge.
 * Simple path : A walk in which no vertices and hence no edges are repeated.
 * Trail : A walk in which no edges are repeated.
 * 
 * Connected graph : In an undirected graph, if there is a path from any vertex to any other vertex.
 * Strongly connected graph : In a directed graph, if there is a path from any vertex to any other vertex.
 * Weakly connected graph : If a directed graph is not connected but on removing directions if they get connected,
 *                           than that graph is weakly connected graph.
 *                           
 * Closed Walk : A walk is a closed walk if it starts and ends at same vertex and length of walk should be greater than 0.
 * Cycle : A closed walk in which no vertices and edge other than the start and end vertices is repeated.
 * Acyclic Graph : A graph with no cycle.
 * DAG : A directed acyclic graph.
 * 
 * Graph representation :
 * 1) Edge List : We use two list, vetrice list and edge list. edge list has objects of classes Edge.
 *                class Edge{
 *                    int startVertexIndex;
 *                    int endVertexIndex;
 *                    int weigth;
 *                }
 *                Space complexity = |v|+|e|
 *                Time complexity for common graph problems :
 *                    Find all nodes adjacent to a node = |e|
 *                    Find if two nodes are connected = |e|
 * 2) Adjacency Matrix :  Space complexity = |v|*|v| {Vertex name and index stored as hashtable, edges stored in an v*v 2-D array}
 *                         Time complexity for common graph problems :
 *                            Find all nodes adjacent to a node = |v|
 *                            Find if two nodes are connected = O(1)
 *                         But space trade off is too huge, and this is good when graph is dense. Also when v^2 is too less to matter.   
 *                         Real world applications like social networking / web pages in www are all sparse graphs.
 *
 *  3)Adjacency List : Similar to above but instead of storing entire matrix, we only store the "1's" that is the connected edge.
 *                     so we will have the list of vertices. space complexity. O(|v|)
 *                     An array of pointer to each vertex's head of linked list. Each vertex has a linked list containing all edges it is connected to.
 *                     This works well in real world applications sine most of the graphs are sparse graphs.
 *                     so the adjacency list space will be way lesser then \v\*(\v\-1).
 *
 *                     Time complexity for common graph problems :
 *                      Find all nodes adjacent to a node = |v|
 *                      Find if two nodes are connected = |v| This is assuming linear search since linked list is used. If we used a binary
 *                                                            tree for all the edges connected to a matrix. Cost of all operations will be
 *                                                            log n (search, insert, delete).
 *

 *       
 * @author sowmyaparameshwara
 *
 */
public class Graphs {

}
