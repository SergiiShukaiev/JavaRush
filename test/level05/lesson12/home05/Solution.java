package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

int k=0;
     //   String s="сумма";
        for (; true;) {
            String i1=reader.readLine();


         if (i1.equals("сумма")) {

            System.out.println(k);
             break;}
            else {
             int i=Integer.parseInt(i1);//  int k=0;
             k +=i;//напишите тут ваш код
         }
        }

    }
}
