package com.problem1.uber;

/**
 * Created by sowmyaparameshwara on 3/24/17.
 */
// valid board example:
// int[][] board = {{7,6,9,3,4,2,1,5,8},
// 				 {3,5,4,7,8,1,6,9,2},
// 				 {1,8,2,6,9,5,4,7,3},
// 				 {5,9,3,1,7,8,2,6,4},
// 				 {4,1,7,2,6,3,5,8,9},
// 				 {6,2,8,9,5,4,3,1,7},
// 				 {8,3,5,4,1,9,7,2,6},
// 				 {2,7,1,8,3,6,9,4,5},
// 				 {9,4,6,5,2,7,8,3,1}};


public class Sudoko{


    public static void main(String[] args){
        int[][] board = {{7,6,9,3,4,2,1,5,8},
                {3,5,4,7,8,1,6,9,2},
                {1,8,2,6,9,5,4,7,3},
                {5,9,3,1,7,8,2,6,4},
                {4,1,7,2,6,3,5,8,9},
                {6,2,8,9,5,4,3,1,7},
                {8,3,5,4,1,9,7,2,6},
                {2,7,1,8,3,6,9,4,5},
                {9,4,6,5,2,7,8,3,1}};
        isValidSudoko(board);
    }


    public static void isValidSudoko(int[][] board){
        boolean rows = checkRowsValid(board);
        if(rows){
            boolean columns = checkColumnsValid(board);
            if(columns){
                boolean grids = checkGridsValid(board);
                if(grids){
                    System.out.println("Valid sudoko");

                }else{
                    System.out.println("Invalid sudoko");

                }
            }else{
                System.out.println("Invalid sudoko");
            }
        }else{
            System.out.println("Invalid sudoko");
        }


    }


    public static boolean checkGridsValid(int[][] board){
        boolean result =true;
        for(int block=0;block<board.length;block++){
            boolean[] visited = new boolean[board.length];
            for(int i = block/3*3; i<block/3*3 +3 ;i++ ){
                for(int j=block%3*3; j<block%3*3 +3 ; j++){
                    int val = board[i][j];
                    if(val>=1 && val<=9 && !visited[val-1]){
                        visited[val-1]=true;
                    }else{
                        return false;
                    }
                }
            }

        }

        return result;



    }

    public static boolean checkRowsValid(int[][] board){
        boolean result =true;
        for(int i=0;i<board.length;i++){
            boolean[] visited = new boolean[board.length];
            for(int j=0;j<board[i].length;j++){
                int val = board[i][j];
                if(val>=1 && val<=9 && !visited[val-1]){
                    visited[val-1]=true;

                }else{
                    return false;
                }
            }
        }


        return result;
    }

    public static boolean checkColumnsValid(int[][] board){
        boolean result =true;
        for(int i=0;i<board.length;i++){
            boolean[] visited = new boolean[board.length];
            for(int j=0;j<board[i].length;j++){
                int val = board[j][i];
                if(val>=1 && val<=9 && !visited[val-1]){
                    visited[val-1]=true;
                }else{
                    return false;
                }
            }

        }

        return result;



    }
}