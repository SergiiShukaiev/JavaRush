package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list=new ArrayList<Integer>();

        for (int i=0; i<20; i++)
            list.add(Integer.parseInt(reader.readLine()));
        int  max=list.get(0);
        int min=list.get(0);

        for (int m:list){
            if (m>max) max=m;
            if (m<min) min=m;
        }

        System.out.println(max+" "+min);
    }
}
