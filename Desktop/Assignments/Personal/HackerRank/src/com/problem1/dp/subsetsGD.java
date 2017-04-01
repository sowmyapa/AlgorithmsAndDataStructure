package com.problem1.dp;

import java.util.ArrayList;

class subsetsGD
 {
	 String s = "abcd";
 	String[] str = new String[(int)Math.pow(2,s.length())];
 	static ArrayList<String> str1 = new ArrayList<String>();
 	
    public static void combinations(String suffix,String prefix){
        if(prefix.length()<0)return;
        int j = suffix.compareTo("");
        if(j!=0)
            str1.add(suffix);
        for(int i=0;i<prefix.length();i++)
         combinations(suffix+prefix.charAt(i),prefix.substring(i+1,prefix.length()));
     
    }
    
    public static void main (String args[])
    {	
        combinations("","abcd");
        for(int k =0;k<str1.size();k++)
        	System.out.println(str1.get(k));
    }
}