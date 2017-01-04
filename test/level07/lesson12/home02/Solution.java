package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(reader.readLine());
        int M=Integer.parseInt(reader.readLine());

        ArrayList<String> list=new ArrayList<String>();
        Collections.addAll(list);
        ArrayList<String> list1=new ArrayList<String>();
        Collections.addAll(list1);

        for (int i=0; i<N; i++)
        list.add(reader.readLine());

        for (int i=M-1; i>=0; i--){
            String b=list.get(i);
            list.remove(i);
            list1.add(0, b); }

        list.addAll(list1);

            for (String h:list)
            System.out.println(h);//напишите тут ваш код

    }
}
