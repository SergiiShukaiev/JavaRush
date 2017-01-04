package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream inputStream=System.in;
        Reader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String a1=bufferedReader.readLine();//напишите тут ваш код
        String b1=bufferedReader.readLine();//напишите тут ваш код
        String c1=bufferedReader.readLine();//напишите тут ваш код
        String d1=bufferedReader.readLine();

        int a=Integer.parseInt(a1);//напишите тут ваш код
        int b=Integer.parseInt(b1);//напишите тут ваш код
        int c=Integer.parseInt(c1);//напишите тут ваш код
        int d=Integer.parseInt(d1);

        if (a>b && a>c && a>d)
        System.out.println(a);

        else if (b>a && b>c && b>d)
        System.out.println(b);

        else if (c>a && c>b && c>d)
        System.out.println(c);

        else if (d>a && d>b && d>c)
        System.out.println(d);//напишите тут ваш код

    }
}
