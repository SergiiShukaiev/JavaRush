package com.javarush.test.level10.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
  //      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        ArrayList[] arrayList=new ArrayList[10];//напишите тут ваш код
        for (int i=0; i<arrayList.length; i++){
            ArrayList<String> list=new ArrayList<String>();
            for (int j=0; j<arrayList.length; j++){
                list.add(String.valueOf(j));
            }
            arrayList[i]=list;
        }

        return arrayList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}