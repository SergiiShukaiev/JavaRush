package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();//напишите тут ваш код
        String b1=reader.readLine();//напишите тут ваш код
        String c1=reader.readLine();

        int a=Integer.parseInt(a1);//напишите тут ваш код
        int b=Integer.parseInt(b1);//напишите тут ваш код
        int c=Integer.parseInt(c1);

        if ((a<b) && (b<c))
            System.out.println(b);
            else if (a<c)
            System.out.println(a);
        else
        System.out.println(c);//напишите тут ваш код

    }
}
