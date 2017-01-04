package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream inputStream=System.in;
        Reader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String n1=bufferedReader.readLine();
        int n=Integer.parseInt(n1);

        String b1=bufferedReader.readLine();
        int b=Integer.parseInt(b1);

        String h1=bufferedReader.readLine();
        int h=Integer.parseInt(h1);

        if (n==b && b==h && h==n)
        System.out.println(n+" "+b+" "+h);

        else if (n==b)
        System.out.println(n+" " +b);

        else if (b==h)
            System.out.println(b+" " +h);

        else if (n==h)
            System.out.println(n+" " +h);//напишите тут ваш код

    }
}