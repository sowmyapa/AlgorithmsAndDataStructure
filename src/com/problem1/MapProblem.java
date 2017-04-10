package com.problem1;

import java.util.*;

public class MapProblem {


	public static void main(String []argh)
	   {

	      Scanner in = new Scanner(System.in);
	      Map<String,Integer> phoneBook = new HashMap<String,Integer>();
	      int n=in.nextInt();
	      in.nextLine();
	      for(int i=0;i<n;i++)
	      {
	         String name=in.nextLine();
	         int phone=in.nextInt();
	         in.nextLine();
	         phoneBook.put(name, phone);
	      }
		   Map<Integer,String> data = new HashMap<Integer,String>();
		   //Set<Map.Entry<Integer,String>> entries = data.entrySet();
		   Set<Map.Entry<String,Integer>> entries = phoneBook.entrySet();
		   Iterator<Map.Entry<String,Integer>> it = entries.iterator();
		   while(it.hasNext()){
		    Map.Entry<String,Integer>	a = it.next();
			   String key = a.getKey();
			   Integer value = a.getValue();
			   System.out.printf("%s = %s%n", key, value);
		   }
		   for(Map.Entry<String,Integer> entry : entries){
			   String key = entry.getKey();
			   Integer value = entry.getValue();
			   System.out.printf("%s = %s%n", key, value);

		   }
	      while(in.hasNext())
	      {
	         String s=in.nextLine();
	         Integer output = phoneBook.get(s);
	         if(output==null)
	         System.out.println("Not found");
	         else 
		         System.out.println(s+"="+output);
 
	      }


	      
	      
	  /*    Map<Integer,String> data = new HashMap<Integer,String>();
	      Set<Map.Entry<Integer, String>> entries = data.entrySet();
	      for(Map.Entry<Integer, String> entry : entries) {
	       Integer key = entry.getKey();
	       String value = entry.getValue();
	       System.out.printf("%s = %s%n", key, value);
	     }
	     
	      System.out.printf("%nUsing Iterator<Map.Entry> and entry set:%n");
	      for(Iterator<Map.Entry<Integer, String>> it = entries.iterator(); it.hasNext();) {
	       Map.Entry<Integer, String> entry = it.next();
	       Integer key = entry.getKey();
	       String value = entry.getValue();
	       System.out.printf("%s = %s%n", key, value);
	     }
	     
	     System.out.printf("%nUsing JDK 5 foreach and key set:%n");
	     for(Integer key : data.keySet()) {
	        String value = data.get(key);
	        System.out.printf("%s = %s%n", key, value);
	      }
	     
	     System.out.printf("%nUsing traditional Iterator and key set%n");
	     for(Iterator<Integer> it = data.keySet().iterator(); it.hasNext();) {
	      Integer key = it.next();
	       String value = data.get(key);
	       System.out.printf("%s = %s%n", key, value);
	     }*/





	   }
	  }

