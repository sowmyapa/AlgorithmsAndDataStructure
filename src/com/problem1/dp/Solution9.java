package com.problem1.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution9 {

	public static void main(String[] args) {

		int[][] followGraph_edges = new int[6][];
		int[][] likeGraph_edges = new int[10][];
		
		followGraph_edges[0] = new int[]{0,1};
		followGraph_edges[1] = new int[]{0,2};
		followGraph_edges[2] = new int[]{0,3};
		followGraph_edges[3] = new int[]{0,4};
		followGraph_edges[4] = new int[]{1,2};
		followGraph_edges[5] = new int[]{1,3};
		
		likeGraph_edges[0] = new int[]{0,105};
		likeGraph_edges[1] = new int[]{1,101};
		likeGraph_edges[2] = new int[]{2,101};
		likeGraph_edges[3] = new int[]{3,101};
		likeGraph_edges[4] = new int[]{4,101};
		likeGraph_edges[5] = new int[]{1,103};
		likeGraph_edges[6] = new int[]{2,103};
		likeGraph_edges[7] = new int[]{3,103};
		likeGraph_edges[8] = new int[]{4,103};
		likeGraph_edges[9] = new int[]{1,105};
		
		
		int[] result = getRecommendedTweets(followGraph_edges, likeGraph_edges, 1, 4);
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
	}

	private static List<Integer> getFollowedPpl(int[][] followGraph_edges, int targetUser){
		List<Integer> followedPpl = new ArrayList<Integer>();
		int[] curInp = null;
		for(int i = 0; i < followGraph_edges.length; i++){
			curInp = followGraph_edges[i];
			if(curInp[0] == targetUser){
				followedPpl.add(curInp[1]);
			}
		}
		return followedPpl;
	}
	
	static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, 
            int targetUser, int minLikeThreshold) {

		List<Integer> finalResult = new ArrayList<Integer>();
		Map<Integer, List<Integer>> likesResult = processTweets(likeGraph_edges);
		List<Integer> followedPpl = getFollowedPpl(followGraph_edges, targetUser);
		
		int curTweetId = 0;
		int curTweetLikeCount = 0;
		for(Map.Entry<Integer, List<Integer>> entry : likesResult.entrySet()){
			curTweetId = entry.getKey();
			
			for(Integer person : followedPpl ){
				if(entry.getValue().contains(person)){
					curTweetLikeCount++;
				}
			}
			
			if(curTweetLikeCount >= minLikeThreshold){
				finalResult.add(curTweetId);
			}
			curTweetLikeCount = 0;
		}
		
		int[] returnVal = new int[finalResult.size()];
		for(int i = 0; i < finalResult.size(); i++){
			returnVal[i] = finalResult.get(i);
		}
		
		return returnVal;
	}
	
	
	private static Map<Integer, List<Integer>> processTweets(int[][] likeGraph_edges){
		
		Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
		List<Integer> curEntry = null;

		int[] curInp = null;
		for(int i = 0; i < likeGraph_edges.length; i++){
			curInp = likeGraph_edges[i];
			if(result.containsKey(curInp[1])){
				curEntry = result.get(curInp[1]);
				if(!curEntry.contains(curInp[0])){
					curEntry.add(curInp[0]);
				}
					
			}
			else{
				curEntry = new ArrayList<Integer>();
				curEntry.add(curInp[0]);
				result.put(curInp[1], curEntry);
			}
			
		}
		
		return result;
	}
}

