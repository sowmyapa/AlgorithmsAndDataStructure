package com.problem1.graphs;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by sowmyaparameshwara on 3/10/17.
 *
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 *
 * http://www.geeksforgeeks.org/applications-of-depth-first-search/
 */
public class DFSGraph {

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

        public void dfs(int start) {
            boolean[] vistied=new boolean[numberOfVertices];
            traverse(start,vistied);
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

        g.dfs(2);

    }
}
