package com.problem1.arrays;

import java.util.Arrays;

/**
 * Created by sowmyaparameshwara on 3/9/17.
 */
public class PrisonBreak {

    static long prison(int n, int m, int[] h, int[] v) {
        short[][] cellHeight=new short[n+1][m+1];
        short one=1;
        for(int i=0;i<=n;i++){
            Arrays.fill(cellHeight[i],one);
        }
        Arrays.sort(h);
        Arrays.sort(v);

        long max=1L;
        for(int i=h.length-1;i>=0;i--){
            int horizontal=h[i];
            for(int j=0;j<=m;j++){


                cellHeight[horizontal-1][j]+=cellHeight[horizontal][j];
                cellHeight[horizontal][j]=-1;
                if(cellHeight[horizontal-1][j]>max){
                    max=cellHeight[horizontal-1][j];
                }

            }
        }

        for(int i=v.length-1;i>=0;i--){
            int vertical=v[i];
            for(int j=0;j<=n;j++){
                cellHeight[j][vertical-1]+= cellHeight[j][vertical];
                cellHeight[j][vertical]=-1;
                if(cellHeight[j][vertical-1]>max){
                    max=cellHeight[j][vertical-1];
                }
            }
        }

        /*long max=1;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(max<cellHeight[i][j]){
                    max=cellHeight[i][j];
                }
            }
        }*/
        return max;


    }
}
