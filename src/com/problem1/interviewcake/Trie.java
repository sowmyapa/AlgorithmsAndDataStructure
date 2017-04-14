package com.problem1.interviewcake;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sowmyaparameshwara on 4/12/17.
 * https://www.interviewcake.com/question/java/compress-url-list
 */

class TrieNode{
    HashMap<Character,TrieNode> characterMap;

    TrieNode(){
        characterMap = new HashMap<>();
    }

    public boolean hasCharacterPrefix(char c) {
        return characterMap.containsKey(c);
    }

    public TrieNode addCharacterPrefix(char c) {
        TrieNode newNode = new TrieNode();
        this.characterMap.put(c,newNode);
        return newNode;
    }

    public TrieNode getCharacterTrieNode(char c) {
        return this.characterMap.get(c);
    }
}

public class Trie {

    TrieNode rootNode;
    private final char endOfWordMarker = '\0';

    public Trie(){
        this.rootNode = new TrieNode();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Trie t = new Trie();
        while(true){
            String input = in.next();
            if(input.isEmpty()){
                System.out.println("Exiting");
                System.exit(0);
            }
            boolean isNewWord = t.insertToTrie(input);
            System.out.println(isNewWord);
        }
    }

    private boolean insertToTrie(String input){
        boolean isNewWord = false;
        TrieNode curNode = this.rootNode;
        for(int i=0; i <input.length();i++){
            char c = input.charAt(i);
            if(!curNode.hasCharacterPrefix(c)){
                isNewWord = true;
                curNode = curNode.addCharacterPrefix(c);
            }else{
                curNode = curNode.getCharacterTrieNode(c);
            }
        }
        if(!curNode.hasCharacterPrefix(endOfWordMarker)){
            curNode.addCharacterPrefix(endOfWordMarker);
        }

        return isNewWord;
    }

}
