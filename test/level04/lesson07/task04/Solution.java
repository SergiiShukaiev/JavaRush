package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String a1=reader.readLine();//напишите тут ваш код
        String b1=reader.readLine();//напишите тут ваш код
        String c1=reader.readLine();

        int a=Integer.parseInt(a1);//напишите тут ваш код
        int b=Integer.parseInt(b1);//напишите тут ваш код
        int c=Integer.parseInt(c1);

        if (a>0 && b>0 && c>0) {
        System.out.println("количество отрицательных чисел: 0");//напишите тут ваш код
        System.out.println("количество положительных чисел: 3"); }

        else if ((a>0 && b>0 && c<0) || (a>0 && c>0 && b<0) || (b>0 && c>0 && a<0)) {
        System.out.println("количество отрицательных чисел: 1");//напишите тут ваш код
        System.out.println("количество положительных чисел: 2"); }

        else if ((a>0 && b<0 && c<0) || (b>0 && a<0 && c<0) || (c>0 && a<0 && b<0)) {
            System.out.println("количество отрицательных чисел: 2");//напишите тут ваш код
            System.out.println("количество положительных чисел: 1"); }

        else if (a<0 && b<0 && c<0) {
            System.out.println("количество отрицательных чисел: 3");//напишите тут ваш код
            System.out.println("количество положительных чисел: 0");//напишите тут ваш код
        }

    }
}
