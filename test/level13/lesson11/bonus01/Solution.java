package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String nameFile=reader.readLine();
        BufferedReader reader1=new BufferedReader(new FileReader(nameFile));
        ArrayList<Integer> list=new ArrayList<Integer>();
        String num=null;
        while((num=reader1.readLine())!=null){
            int data=Integer.parseInt(num);
            list.add(data);
        }
        sortA(list);
        print(list);

        reader1.close();
        reader.close();
    }
    public static void sortA(ArrayList<Integer> list){
        ArrayList<Integer> mod=new ArrayList<Integer>();
        for ( int i=0; i<list.size();i++)
        {
            if (list.get(i) % 2 == 0)
            {
                mod.add(list.get(i));
            }
            list.remove(i);
            i--;
        }
          int[] array=new int[mod.size()];
            for (int i=0; i<array.length; i++){
                array[i]=mod.get(i);
            }
        Arrays.sort(array);
       for (int i=0; i<array.length; i++)
           list.add(array[i]);
    }
    public static void print(ArrayList<Integer> list){
        for (Integer a:list)
            System.out.println(a);
    }
}
