package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        String c1=bufferedReader.readLine();

        int a=Integer.parseInt(a1);//напишите тут ваш код
        int b=Integer.parseInt(b1);//напишите тут ваш код
        int c=Integer.parseInt(c1);

        if (a>b && a>c)
        { if (b>c)
            System.out.println(a+" "+b+" "+c);
            else
            System.out.println(a+" "+c+" "+b);}
        else if (b>c && b>a)
        { if (a>c)
            System.out.println(b+" "+a+" "+c);
            else
            System.out.println(b+" "+c+" "+a);}
        else if (c>a && c>b)
        { if (a>b)
            System.out.println(c+" "+a+" "+b);
            else
            System.out.println(c+" "+b+" "+a);}//напишите тут ваш код

    }
}
