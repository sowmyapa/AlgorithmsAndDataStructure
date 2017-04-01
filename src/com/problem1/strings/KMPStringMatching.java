package com.problem1.strings;

/**
 * Created by sowmyaparameshwara on 3/22/17.
 */
public class KMPStringMatching {

    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
       String pat = "ABABCABAB";
        //String pat = "ABCDABCY";

        new KMPStringMatching().KMPSearch(pat,txt);
    }

    private void KMPSearch(String pat, String txt) {

        int[] lps = createLPSArray(pat);
       /* for(int i : lps){
            System.out.println(i);
        }*/
       int i=0,j=0;
        while(i<txt.length()){
            if(pat.charAt(j)==txt.charAt(i)){
                j++;
                i++;
            }
           if(j==pat.length()){
                System.out.println("String found at : "+(i-pat.length()));
                j=lps[j-1];
            } else if(j<pat.length() && pat.charAt(j)!=txt.charAt(i)){
                if(j==0){
                    i++;
                }else {
                    j = lps[j - 1];
                }
            }

        }

    }

    private int[] createLPSArray(String pat) {
        int[] lps=new int[pat.length()];
        lps[0] = 0;
        for(int i=1;i<pat.length();i++){
            int j = lps[i-1];
            if (pat.charAt(i)==pat.charAt(j)){
                lps[i]=j+1;
            }
        }
        return lps;
    }
}
