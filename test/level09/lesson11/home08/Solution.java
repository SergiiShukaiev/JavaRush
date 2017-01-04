package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list=new ArrayList<int[]>();
        int[] list5=new int[5];
        int[] list2=new int[2];
        int[] list4=new int[4];
        int[] list7=new int[7];
        int[] list0=new int[0];

        for (int i=0; i<list5.length; i++)
        list5[i]=(int) (Math.random()*100);

        for (int i=0; i<list2.length; i++)
        list2[i]=(int) (Math.random()*100);

        for (int i=0; i<list4.length; i++)
        list4[i]=(int) (Math.random()*100);

        for (int i=0; i<list7.length; i++)
        list7[i]=(int) (Math.random()*100);

        list.add(list5);//напишите тут ваш код
        list.add(list2);//напишите тут ваш код
        list.add(list4);//напишите тут ваш код
        list.add(list7);//напишите тут ваш код
        list.add(list0);//напишите тут ваш код

        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
