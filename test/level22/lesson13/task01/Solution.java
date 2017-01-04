package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer=new StringTokenizer(query, delimiter);
        String[] tok;
        ArrayList<String> to=new ArrayList<String>();
        while(tokenizer.hasMoreTokens()){
            String token=tokenizer.nextToken();
            to.add(token);
        }
        tok=new String[to.size()];
        for(int i=0; i<tok.length; i++){
            tok[i]=to.get(i);
        }

        return tok;
    }
 /*   public static void main(String[] args){

        String[] s=(getTokens("level22.lesson13.task01", "."));
        for (String str:s)
            System.out.print(str+" ");
    }*/
}
