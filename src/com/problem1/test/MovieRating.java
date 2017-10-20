package com.problem1.test;

import java.util.*;

/**
 * Created by sowmyaparameshwara on 9/5/17.
 */
public class MovieRating {

    public static void main(String[] args){
        Movie movie = new Movie();
        int n=10;
        determineBFS(n,movie);
    }

    private static Set<Movie> determineBFS(int n,Movie movie) {
        HashSet<Movie> results = new HashSet<>();
        Queue<Movie> queue = new LinkedList<>();
        queue.add(movie);
        HashMap<Integer,Boolean> visited = new HashMap<>();
        visited.put(movie.uid,true);
        PriorityQueue<Movie> sorted = new PriorityQueue<>(new Comparator<Movie>(){
            @Override
            public int compare(Movie o1, Movie o2) {
                return new Float(o2.rating).compareTo(new Float(o1.rating));
            }
        });
        while(!queue.isEmpty()){
            for(Movie neighbour: movie.nearBy){
                if(!visited.containsKey(neighbour)){
                    visited.put(neighbour.uid,true);
                    queue.add(neighbour);
                    sorted.add(neighbour);
                }
            }
        }
        int count=0;
        while(count<n && !queue.isEmpty()){
            results.add(queue.poll());
            count++;
        }
        return results;
    }
}

class Movie{

    float rating;

    int uid;

    ArrayList<Movie> nearBy;

    Movie(){

    }

    Movie(int rating,int uid,ArrayList<Movie> nearBy){
        this.rating = rating;
        this.uid = uid;
        this.nearBy = nearBy;
    }

}
