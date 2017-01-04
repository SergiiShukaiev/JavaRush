package com.javarush.test.level04.lesson04.task05;

/* Положительное и отрицательное число
Ввести с клавиатуры число. Если число положительное, то увеличить его в два раза. Если число отрицательное, то прибавить единицу.
Вывести результат на экран.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
     InputStream inputStream=System.in;
        Reader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String s=bufferedReader.readLine();
        int ns=Integer.parseInt(s);

       // public static   /*(int min)*/{
//int min;
   // if (min<0)
     //   min=min+1;
      //  else
     //   min=min*2;
       // return min; */
        if (ns<0)
            System.out.println(ns+1);
        else
           System.out.println(ns*2);
        //return ns;
}//напишите тут ваш код

    }

