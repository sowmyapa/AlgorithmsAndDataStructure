package com.problem1.dp;

import java.util.ArrayList;
import java.util.Collections;

public class Times {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Times t = new Times();
		t.solution(1, 2, 9, 5);

	}

	public String solution(int a, int b, int c, int d) {

		ArrayList<Integer> validCombinations = this.getCombinations(a, b, c, d);
		if(validCombinations.size() == 0){
			return "NOT POSSIBLE";
		}
		Collections.sort(validCombinations);
		
		int result = validCombinations.get(validCombinations.size() - 1);
		System.out.println("Times.solution() result "+result);
		
		String res = Integer.toString(result);
		if(res.length() == 3){
			res = "0"+res;
		}else if(res.length() == 2){
			res = "00"+res;
		}else if(res.length() == 1){
			res = "000"+res;
		}
		System.out.println("Times.solution() res "+res.charAt(0)+res.charAt(1)+":"+res.charAt(2)+res.charAt(3));
		
		res = ""+res.charAt(0)+res.charAt(1)+":"+res.charAt(2)+res.charAt(3);
		System.out.println("Times.solution() res "+res);
		return res;
	}

	private ArrayList<Integer> getCombinations(int p, int q, int r, int s){
		
		int[] arr = new int[]{p,q,r,s};
		ArrayList<Integer> reqArr  = new ArrayList<Integer>();

		int no; 
		for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    for(int l = 0; l < 4; l++){
                        if(!(i == j || i == k || i == l || j == k || j == l || k == l)){
                            if((no = Integer.parseInt(""+arr[i]+arr[j]+arr[k]+arr[l])) < 2400 && arr[k] < 6){
                            	
                            	reqArr.add(no);
                            	System.out.println("Times.getCombinations() no "+no);
                            }
                        }    
                    }    
                }    
            }    
        }    
        
		return reqArr;
	}
}
