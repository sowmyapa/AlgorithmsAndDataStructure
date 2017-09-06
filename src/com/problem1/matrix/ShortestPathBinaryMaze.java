package com.problem1.matrix;

import java.awt.*;
import java.util.*;

/**
 * http://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
 */
public class ShortestPathBinaryMaze {

    static int[] rowNum = {-1,0,0,1};
    static int[] colNum = {0,-1,1,0};

    public static void main(String[] args){
        int[][] mat = new int[][] { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };

        Point source = new Point(0, 0);
        Point dest = new Point(3, 4);

        int dist = bfs(mat, source, dest);

        if (dist != Integer.MAX_VALUE)
            System.out.println("Shortest Path is "+ dist);
        else
            System.out.println("Shortest Path doesn't exist");
    }

    private static int bfs(int[][] mat, Point source, Point dest) {
        if(mat[source.x][source.y]==0 || mat[dest.x][dest.y]==0)
            return Integer.MAX_VALUE;
        boolean[][] visited = new boolean[mat.length][mat.length];
        int dist = 0;
        Queue<Cell> q = new ArrayDeque<Cell>();
        q.add(new Cell(new Point(source.x,source.y),0));
        visited[source.x][source.y]=true;
        while(!q.isEmpty()){
            Cell cell = q.poll();
            if(cell.point.getX()==dest.x && cell.point.getY()==dest.y)
                return cell.dist;
            for(int i=0 ;i<4; i++){
                int row = cell.point.x+rowNum[i];
                int col = cell.point.y+colNum[i];
                if(isValid(row,col) && mat[row][col]==1 && !visited[row][col]){
                    q.add(new Cell(new Point(row,col),cell.dist+1));
                    visited[row][col] = true;
                }
            }
        }
        return dist;
    }

    private static boolean isValid(int row, int col) {
        if(row>=0 && row<10 && col>=0 && col<10){
            return true;
        }
        return false;
    }

}

class Cell{

    Point point;
    int dist;

    public Cell(Point point, int dist) {
        this.point = point;
        this.dist = dist;
    }

}
