package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       String a1=reader.readLine();
        String b1=reader.readLine();
        String c1=reader.readLine();

        int a=Integer.parseInt(a1);//напишите тут ваш код
        int b=Integer.parseInt(b1);//напишите тут ваш код
        int c=Integer.parseInt(c1);

        if (a==b)
        System.out.println(3);

        else if(a==c)
        System.out.println(2);

        else if (b==c)
        System.out.println(1);//напишите тут ваш код

    }
}
