package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        InputStream in=new FileInputStream(reader.readLine());
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> minList=new ArrayList<Integer>();

        while(in.available()>0){
            int date=in.read();
            list.add(date);
        }
        int[] count=new int[list.size()];
        for(int i=0; i<list.size();i++){
            count[i]=0;
            for(int j=0; j<list.size(); j++){
                if(list.get(i)==(list.get(j))) count[i]++;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i:count){
            if(i<min) min=i;
        }
        for(int i=0; i<list.size(); i++){
            if(!minList.contains(list.get(i))&& count[i]==min)
                minList.add(list.get(i));
        }
        for(int i: minList)
            System.out.println(i+" ");
        in.close();
        reader.close();
    }
}
