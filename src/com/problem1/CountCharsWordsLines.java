package com.problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountCharsWordsLines {

	public static void main(String[]args) throws FileNotFoundException        
    { 
		Scanner console = new Scanner(System.in);           

        System.out.println("File to be read: ");
        String inputFile = console.next();
        File file = new File(inputFile);
        Scanner in = new Scanner(file);

        int words = 0;
        int lines = 0;
        int chars = 0;
        while(in.hasNextLine()){
        	lines++;
        	String line = in.nextLine();
        	int tokens = new StringTokenizer(line).countTokens();
        	words+=tokens;
        	chars+=line.length();
        	chars-=tokens>0?tokens-1:0;

        }
        System.out.println("chars: "+chars);
        System.out.println("words: "+words);
        System.out.println("lines: "+lines);

        StringTokenizer s = new StringTokenizer("ht/22/33","/");
        while(s.hasMoreElements()){
            System.out.println("Has more elements: "+s.nextToken());
        }


    }
}
