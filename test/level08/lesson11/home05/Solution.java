package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();


       char[] text=s.toCharArray();
     //   if (Character.isLetter(text[0]))
        text[0]=Character.toUpperCase(text[0]);

        for (int i=1; i<text.length; i++){
            if (Character.isSpaceChar(text[i-1]) && Character.isLetter(text[i]))
            text[i]=Character.toUpperCase(text[i]); }

            System.out.print(text);
    }
}
