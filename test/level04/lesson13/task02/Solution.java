package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String m1=reader.readLine();
        String n1=reader.readLine();

        int m=Integer.parseInt(m1);
        int n=Integer.parseInt(n1);


        for (int j=1; j<=m; j++){
            for (int i=1; i<n; i++){
                System.out.print("8");//напишите тут ваш код
            }
            System.out.println("8");
        }

    }
}
