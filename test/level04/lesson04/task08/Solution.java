package com.javarush.test.level04.lesson04.task08;

/* Треугольник
Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
Определить возможность существования треугольника по сторонам. Результат вывести на экран в следующем виде:
"Треугольник существует." - если треугольник с такими сторонами существует.
"Треугольник не существует." - если треугольник с такими сторонами не существует.
Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
Требуется сравнить каждую сторону с суммой двух других.
Если хотя бы в одном случае сторона окажется больше суммы двух других, то треугольника с такими сторонами не существует.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
      InputStream inputStream=System.in;
        Reader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String a=bufferedReader.readLine();
        int a1=Integer.parseInt(a);

        String b=bufferedReader.readLine();
        int b1=Integer.parseInt(b);

        String c=bufferedReader.readLine();
        int c1=Integer.parseInt(c);


    /*    if (a>b+c)
            System.out.println("Треугольник не существует");

      else  if (b>c+a)
            System.out.println("Треугольник не существует");

       else  if  (c>a+b)
            System.out.println("Треугольник не существует");

        else
            System.out.println("Треугольник не существует"); */



        if (a1>=b1+c1 || b1>=c1+a1 || c1>=b1+a1)
            System.out.println("Треугольник не существует.");
        else
            System.out.println("Треугольник существует.");



      /*  if ((a+b)>c)
                       System.out.println("Треугольник существует");

        else if ((a+c)>b)
            System.out.println("Треугольник существует");

        else if  ((b+c)>a)
            System.out.println("Треугольник существует");

        else
        System.out.println("Треугольник не существует"); */
    }


    }
