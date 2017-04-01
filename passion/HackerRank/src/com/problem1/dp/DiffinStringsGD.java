package com.problem1.dp;

import java.util.*;

public class DiffinStringsGD
{

static String[] check(String s,String t){
    int i=0,j=0,k=0;
    String s1[] = s.split(" ");
    String t1[] = t.split(" ");
        int m=s1.length;
        int n=t1.length;
    String[] st=new String[m-n]; 
    while(i<m && j<n)
    {
        if(s1[i].compareTo(t1[j])==0)
        {
            i++;j++;
        }
        else
        {
            st[k]=s1[i];
            k++;i++;
        }
    }
    for(int f=i;f<m;f++)
    {
        st[k]=s1[f];
        k++;
    }
    for(int f=j;f<n;f++){
        st[k]=s1[f];
        k++;
    }
    return st;
}

     public static void main(String []args){
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        String t=in.nextLine();
        String[] str =check(s,t);
        System.out.println(Arrays.asList(str));
     }
}