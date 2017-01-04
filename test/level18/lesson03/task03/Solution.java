package com.javarush.test.level18.lesson03.task03;

import java.io.*;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> b=new ArrayList<Integer>();
        ArrayList<Integer> ba=new ArrayList<Integer>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        InputStream in=new FileInputStream(reader.readLine());
        int max=Integer.MIN_VALUE;
        while(in.available()>0){
            int date=in.read();
            b.add(date);
        }
        int[] count=new int[b.size()];
        for(int i=0; i<b.size();i++){
            count[i]=0;
            for(int j=0; j<b.size(); j++){
                if (b.get(i)==b.get(j))
                    count[i]++;
            }
        }
        for(int c:count){
            if(c>max) max=c;
        }
        for(int i=0; i<b.size(); i++){
            if(!ba.contains(b.get(i))&&count[i]==max)ba.add(b.get(i));
        }
        for(int a:ba)
            System.out.println(a+" ");

        in.close();
        reader.close();
    }
}
