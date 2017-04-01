package com.problem1.dp;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Hiya2 {

	     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nextjump=0,max=0,ans=0;
        ArrayList<Integer> al=new ArrayList();
        ArrayList<Integer> result=new ArrayList();
        boolean reached = false;

        // int t=sc.nextInt();
        /*for(int i=0;i<t;i++)

        {
            al.add(sc.nextInt());
        }
*/        
       while(sc.hasNext()){
        	al.add(Integer.parseInt(sc.next()));
        }
        int prevIndex = -1;
        for(int i=0;i<al.size();i++)
        {
        	result.add(i);
        	prevIndex = i;
        	i = getMostUsefulReachableNode(i, al, max);
        	if(i == prevIndex ){
        		break;
        	}
        	max = getMaxPathPossible(i, al); 
        	
        	if(max > al.size() - 1){
        		reached = true;
        		result.add(i);
        		break;
        	}
        	i--;
        }
        if(result.size() > 0 && reached){
        	for(int i = 0; i < result.size(); i++){
        		System.out.print(""+result.get(i)+", ");
        	}
        	System.out.println("out");
        	
        }
        else{
        	System.out.println("failure");
        }
    }

	private static int getMostUsefulReachableNode(int i, ArrayList<Integer> al, int max) {
		int curMax = 0; 
		int count = i + al.get(i); //7
		if(count > al.size() - 1){
			count = al.size() - 1;
		}
		int res = max;
		for(int j = i+1; j <= count; j++){
			if(al.get(j) == 0 ){
				continue;
			}
			else{
				int temp = getMax(j, al); 
				if( temp > curMax){
					curMax = temp;
					res = j;
				}
			}
		}
		if(curMax > max){
			return res;
		}
		else{
			return max;
		}
	}
	
	/*
	 * Given a element return the max valid jump from there.
	 */
	private static int getMax(int k, ArrayList<Integer> al){
		if(k > al.size() - 1){
			return k;
		}
		
		int count = k + al.get(k);
		if(count > al.size() - 1){
			count = al.size() - 1;
		}
		for(int p = count; p > k; p--){
			if(al.get(p) != 0){
				return p;
			}
		}
		return k;
	}
    
	private static int getMaxPathPossible(int k, ArrayList<Integer> al){
		if(k > al.size() - 1){
			return k;
		}
		
		int count = k + al.get(k);
		if(count > al.size() - 1){
			return count;
		}
		for(int p = count; p > k; p--){
			if(al.get(p) != 0){
				return p;
			}
		}
		return k;
	}
    
}