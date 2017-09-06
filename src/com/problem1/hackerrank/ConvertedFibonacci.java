package com.problem1.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified/problem
 */
public class ConvertedFibonacci {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        String[] vals = line.split(" ");
        BigInteger a = new BigInteger(vals[0]);
        BigInteger b = new BigInteger(vals[1]);
        BigInteger n = new BigInteger(vals[2]);
        BigInteger answer = fibMod(a,b,n);
        System.out.println(answer);
    }

    public static BigInteger fibMod(BigInteger a, BigInteger b, BigInteger n){
        //Tn+2 = (Tn+1)2 + Tn
        BigInteger b2 = b.multiply(b); //get the third term.
        BigInteger answer = b2.add(a);
        a = b; //set A to become b aka n+1 = n now;
        b = answer;
        for(int i=3; i<n.intValue(); i++){
            b2 = b.multiply(b);
            answer = b2.add(a);
            a = b;
            b = answer;
        }

        return answer;
    }

}
