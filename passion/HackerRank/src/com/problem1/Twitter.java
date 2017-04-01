package com.problem1;

import java.util.Scanner;
import java.util.Stack;


/**
 * Created by sowmyaparameshwara on 2/26/17.
 */
public class Twitter {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNextLine()){

            String input = in.nextLine();
            if(input.isEmpty()){
                break;
            }
            String[] splitInputExpression = input.split("/");
            String expression = splitInputExpression[0];
            String operation="";
            if(splitInputExpression.length==2)
                operation = splitInputExpression[1];

            handleTransformation(expression,operation);

        }
    }

    private static void handleTransformation(String expression, String operation) {
        // TODO Auto-generated method stub

        if(operation.isEmpty()){
            for(int i=0;i<expression.length();i++){
                if(expression.charAt(i)!=' ')
                    System.out.print(expression.charAt(i));
            }
            System.out.println();
        }else{

            handleTranformationWithOperation(expression,operation);
        }


    }

    private static void handleTranformationWithOperation(String expression, String operation) {
        int countR=0,countS=0;
        for(int i =0;i<operation.length();i++)
        {
            char op=operation.charAt(i);
            if(op=='R'){
                expression=performReverse(expression);
            }else if(op=='S'){
                expression=performSimplify(expression);
            }
        }
        System.out.println(expression);


    }





    private static String performReverse(String expression) {
        Stack inputStack=new Stack();
        String output="";
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)!=' '){
                inputStack.push(expression.charAt(i));
            }
        }
        while(!inputStack.isEmpty()){
            char symbol=(char) inputStack.pop();
            if(symbol==')'){
                output=output.concat(String.valueOf("("));
            }else if(symbol=='('){
                output=output.concat(String.valueOf(")"));
            }else{
                output=output.concat(String.valueOf(symbol));

            }
        }
        return output;

    }







    private static String performSimplify(String expression) {

        String simplified="";
        int maxFilled=-1;
        int[] bracketValues=new int[expression.length()];

        for(int i=0;i<expression.length();i++){
            char symbol = expression.charAt(i);
            if(symbol=='(' && (i==0 || expression.charAt(i-1)=='(')){
                ++maxFilled;
                for(int j=0;j<=maxFilled  ;j++){
                    bracketValues[j]=bracketValues[j]+1;
                }
            }else if(symbol=='('){
                simplified=simplified.concat(String.valueOf('('));
                for(int j=0;j<=maxFilled  ;j++){
                    bracketValues[j]=bracketValues[j]+1;
                }
            }else if(symbol==')'){
                for(int j=0;j<=maxFilled ;j++){
                    bracketValues[j]=bracketValues[j]-1;
                }
                if(maxFilled==-1 || bracketValues[maxFilled]!=0){
                    simplified=simplified.concat(String.valueOf(')'));
                }else{

                        maxFilled--;

                }
            }else{
                simplified=simplified.concat(String.valueOf(symbol));

            }

        }
        return simplified;

    }

}
