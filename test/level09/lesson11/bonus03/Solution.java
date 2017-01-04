package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<String> str = new ArrayList<String>();
        ArrayList<Integer> inT = new ArrayList<Integer>();
        ArrayList<Integer> poz = new ArrayList<Integer>();

        int size = array.length;
        int count = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
            {
                Integer num = Integer.parseInt(array[i]);
                inT.add(num);
                poz.add(i);
                count++;//напишите тут ваш код
            } else
            {
                str.add(array[i]);
            }
        }


        for (int i = 0; i < str.size(); i++)
        {
            for (int j = 0; j < str.size() - 1 - i; j++)
            {
                if (isGreaterThan(str.get(j), str.get(j + 1)))
                {
                    String word = str.get(j + 1);
                    str.set(j + 1, str.get(j));
                    str.set(j, word);
                }
            }
        }

        for (int i = 0; i < inT.size(); i++)
        {
            for (int j = 0; j < inT.size() - 1 - i; j++)
            {
                if ((inT.get(j+1) > inT.get(j)))
                {
                    int num = inT.get(j);
                    inT.set(j, inT.get(j+1));
                    inT.set(j+1, num);
                }
            }
        }
count=0;
        int wordcount=0;
        for(int i=0; i<array.length; i++){
            if(isNumber(array[i])){
                array[i]= Integer.toString(inT.get(count));
                count++;
            } else {
                array[i]=str.get(wordcount);
                wordcount++;
            }
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
