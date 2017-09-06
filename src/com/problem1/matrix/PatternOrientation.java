package com.problem1.matrix;

/**
 * http://www.geeksforgeeks.org/find-orientation-of-a-pattern-in-a-matrix/
 */
public class PatternOrientation {

    public static void main(String[] args){
        char[][] mat =
        {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'}

        };
        String pat = "pqrs";

        findOrientation(mat, pat);

        pat = "afkp";

        findOrientation(mat, pat);
    }

    private static void findOrientation(char[][] mat, String pat) {
        for(int i=0;i<mat.length;i++){
            if(kmpSearch(mat[i],pat)){
                System.out.println("Horizontal");
            }
            char[] col = new char[mat.length];
            for(int j=0;j<mat.length;j++){
                col[j]=mat[j][i];
            }
            if(kmpSearch(col,pat)){
                System.out.println("Vertical");
            }

        }
    }

    private static boolean kmpSearch(char[] mat, String pat) {
        boolean isFound = false;
        int[] lps = createLPSArray(mat);
        int i=0,j=0;
        while(i<mat.length){
            if(mat[i]==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==pat.length()-1){
                return true;
            }else if(mat[i]!=pat.charAt(j)){
                if(j==0)
                    i++;
                else
                    j = lps[j-1];
            }

        }
        return isFound;
    }

    private static int[] createLPSArray(char[] mat) {
        int[] lps = new int[mat.length];
        lps[0]=0;
        for(int i=1;i<mat.length;i++){
            int j = lps[i-1];
            if(mat[i]==mat[j]){
                lps[i] = j+1;
            }
        }
        return lps;
    }

}
