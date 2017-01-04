package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
      InputStream inputStream=System.in;
        Reader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String name=bufferedReader.readLine();
        String age1=bufferedReader.readLine();
        int age=Integer.parseInt(age1);

        if (age<18)
        System.out.println("Подрасти еще");//напишите тут ваш код

    }
}
