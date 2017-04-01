package com.problem1.strings;

import java.util.Arrays;

/**
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * Created by sowmyaparameshwara on 3/22/17.
 */
public class LongestNonRepeatingSubstring {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n>0){
            int[] visited = new int[256];
            int cur_len=1;
            int max_len=1;
            Arrays.fill(visited,-1);

            visited[s.charAt(0)]=0;
            for(int i=1;i<n;i++){
                int prevIndex=visited[s.charAt(i)];

                if(prevIndex==-1 || i-cur_len>prevIndex)
                    cur_len++;
                else{
                    if(cur_len>max_len){
                        max_len=cur_len;
                    }
                    cur_len=i-prevIndex;
                }
                visited[s.charAt(i)]=i;
            }
            if(cur_len>max_len)
                max_len=cur_len;
            return max_len;
        }else{
            return 0;
        }

    }
}
