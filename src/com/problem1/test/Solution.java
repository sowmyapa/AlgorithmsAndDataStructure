package com.problem1.test;


import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

    }

    public int checkWinner(List<List<String>> codeList, List<String> shoppingCart){
        if(codeList.size()==0)
            return 1;
        if(shoppingCart.size()==0)
            return 0;

        int groupIndex=0;
        while(codeList.size()>groupIndex && codeList.get(groupIndex).size()==0){
            groupIndex++;
        }
        if(codeList.size()<groupIndex)
            return 0;
        int itemIndex=0;
        boolean isBeginningOfGroup=true;
        int i;
        for(i=0;i<shoppingCart.size();i++){
            String shoppingCartItem = shoppingCart.get(i);
            String nextItem = codeList.get(groupIndex).get(itemIndex);
            if(isBeginningOfGroup) {
                while (!itemsEqual(shoppingCartItem,nextItem)) {
                    if(i==shoppingCart.size()-1){
                        return 0;
                    }else{
                        shoppingCartItem = shoppingCart.get(++i);
                    }
                }
                itemIndex++;
                if(itemIndex== codeList.get(groupIndex).size()){
                    itemIndex=0;
                    groupIndex++;
                    isBeginningOfGroup = true;
                    if(groupIndex==codeList.size()){
                        return 1;
                    }
                }else{
                    isBeginningOfGroup = false;
                }
            }else {
                if (itemsEqual(shoppingCartItem,nextItem)) {
                    itemIndex++;
                    if (itemIndex == codeList.get(groupIndex).size()) {
                        itemIndex = 0;
                        groupIndex++;
                        isBeginningOfGroup = true;
                        if(groupIndex==codeList.size()){
                            return 1;
                        }
                    }
                }else{
                    itemIndex=0;
                    isBeginningOfGroup = true;
                }
            }

        }
        return 0;
    }

    private boolean itemsEqual(String shoppingCartItem, String nextItem) {
        if(nextItem.equals("anything") && !shoppingCartItem.isEmpty())
            return true;
        else
            return shoppingCartItem.equals(nextItem);
    }

}
