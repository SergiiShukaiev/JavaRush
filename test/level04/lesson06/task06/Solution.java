package com.javarush.test.level04.lesson06.task06;

/* И 18-ти достаточно
Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись «И 18-ти достаточно».
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

        if (age>20)
            System.out.println("И 18-ти достаточно");  //напишите тут ваш код

    }
}
