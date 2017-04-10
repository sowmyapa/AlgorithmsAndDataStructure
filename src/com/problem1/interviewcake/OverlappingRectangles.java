package com.problem1.interviewcake;

import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/4/17.
 * https://www.interviewcake.com/question/java/rectangular-love
 */
public class OverlappingRectangles {

    public static class Rectangle {

        // coordinates of bottom left corner
        Integer leftX;
        Integer bottomY;

        // dimensions
        Integer width;
        Integer height;

        public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }


        public String toString() {
            return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
        }
    }

    public static class RangeOverlap{
        int startingPoint;
        int overlap;

        RangeOverlap(int startingPoint, int overlap){
            this.startingPoint = startingPoint;
            this.overlap = overlap;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Rectangle r1 = new Rectangle(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
        in.nextLine();
        Rectangle r2 = new Rectangle(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
        findOverlapRectangle(r1,r2);

    }

    private static void findOverlapRectangle(Rectangle r1, Rectangle r2) {
        RangeOverlap xOverlap = findOverlap(r1.leftX,r1.width,r2.leftX,r2.width);
        RangeOverlap yOverlap = findOverlap(r1.bottomY,r1.height,r2.bottomY,r2.height);
        if(xOverlap==null || yOverlap==null){
            System.out.println("No overlap");
        }else{
            System.out.println("Overlap : "+new Rectangle(xOverlap.startingPoint,yOverlap.startingPoint,xOverlap.overlap,yOverlap.overlap));
        }

    }


    private static RangeOverlap findOverlap(int point1,int length1,int point2,int length2){
        int startingPointOverlap = Math.max(point1,point2);
        int endingPointOverlap = Math.min(point1+length1,point2+length2);
        if(startingPointOverlap>endingPointOverlap){
            return null;
        }
        int overlap = endingPointOverlap - startingPointOverlap;
        return new RangeOverlap(startingPointOverlap,overlap);

    }
}
