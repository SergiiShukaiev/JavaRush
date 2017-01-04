package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       InputStream inputStream=System.in;
        Reader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String a1=bufferedReader.readLine();
        String b1=bufferedReader.readLine();
        int a=Integer.parseInt(a1);
        int b=Integer.parseInt(b1);

        if (a<b)
        System.out.println(a);
        else
        System.out.println(b);//напишите тут ваш код

    }
}