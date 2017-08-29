package com.problem1.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sowmyaparameshwara on 8/25/17.
 */
public class Trie {

    TrieNode rootNode;

    char endOfStringMarker = '\0';

    Trie(){
        this.rootNode = new TrieNode();
    }

    public static void main(String[] args){
        Trie t = new Trie();
        //Scanner in = new Scanner(System.in);
        //String input = in.next();
        String[] input = new String[]{"one","two","once","on","apple","two","hello_one","hi_onc","hi_once"};
        for(String in : input){
            boolean isNewWord = t.insertString(in);
            System.out.println("Is new word: "+isNewWord);
            if(in.contains("_")){
                isNewWord = t.insertBySuffix(in);
                System.out.println("Is new word: "+isNewWord);

            }
        }
        String[] search = new String[]{"one","two","on","onne","zebra","onc"};
        for(String in : search){
            boolean isWordPresent = t.searchString(in);
            System.out.println("Is word present: "+isWordPresent);
        }

        List<String> result = t.searchByPrefix("on");
        for(String res : result){
            System.out.println("Prefix search present in: "+res);
        }
        result.clear();
        result = t.searchByUnderScore("on");
        for(String res : result){
            System.out.println("Prefix search with _ : "+res);
        }
    }

    private List<String> searchByUnderScore(String input) {
        return searchByPrefix("_".concat(input)).stream().map(s->convert(s)).collect(Collectors.toList());
    }

    private <R> String convert(String s) {
        int index = s.indexOf("/");
        return  s.substring(index+1,s.length()).concat(s.substring(0,index));

    }


    /**
     * Starts by given string 's' or contains '_s'
     * @param input
     */
    private List<String> searchByPrefix(String input) {
        List<String> result = new ArrayList<>();
        TrieNode curNode = rootNode;
        int i;
        for(i = 0 ; i <input.length(); i++){
            char c = input.charAt(i);
            if(curNode.hasCharacter(c)){
                curNode =  curNode.getTrieNode(c);
            } else{
                break;
            }
        }
        if(i == input.length()){
            curNode.DFSTraversal(result,input);
        }
        return result;
    }

    private boolean insertBySuffix(String input) {
        int index = input.indexOf("_");
        String newString = input.substring(index).concat("/").concat(input.substring(0,index));
        return insertString(newString);
    }

    private boolean searchString(String input) {
        TrieNode curNode = rootNode;
        for(int i=0 ; i <input.length(); i++){
            char c = input.charAt(i);
            if(curNode.hasCharacter(c)){
                curNode = curNode.getTrieNode(c);
            }else{
                return false;
            }
        }
        if(curNode.hasCharacter(endOfStringMarker)){
            return true;
        }
        return false;
    }

    private boolean insertString(String input) {
        TrieNode curNode = rootNode;
        boolean isNewWord = false;
        for(int i=0; i< input.length();i++){
            char c = input.charAt(i);
            if(curNode.hasCharacter(c)){
                curNode = curNode.getTrieNode(c);
            }else{
                curNode = curNode.addCharacter(c);
                isNewWord = true;
            }
        }
        if(!curNode.hasCharacter(endOfStringMarker)) {
            curNode.addCharacter(endOfStringMarker);
            isNewWord = true;
        }
        return isNewWord;
    }

}

class TrieNode{

    char endOfStringMarker = '\0';

    HashMap<Character, TrieNode> characterMap;

    TrieNode(){
        characterMap = new HashMap<>();
    }

    public boolean hasCharacter(char c) {
        return characterMap.containsKey(c);
    }

    public TrieNode getTrieNode(char c) {
        return characterMap.get(c);
    }

    public TrieNode addCharacter(char c) {
        TrieNode newNode = new TrieNode();
        characterMap.put(c,newNode);
        return newNode;
    }

    public String DFSTraversal(List<String> result, String word) {
        for(Map.Entry<Character,TrieNode> entrySet : this.characterMap.entrySet()){
            if(entrySet.getKey().equals(endOfStringMarker)){
                result.add(word);
            }else{
                word = word.concat(String.valueOf(entrySet.getKey()));
                word = entrySet.getValue().DFSTraversal(result,word);
            }
        }
        return word.substring(0,word.length()-1);
    }
}
