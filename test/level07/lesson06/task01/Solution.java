package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{




    public static void main(String[] args) throws Exception
    {
    /*    String[] c={"eee", "xxx", "rrr", "ttt", "qqq", "www", "ddd", "ede", "fdw", "ds", "dfsd", "rfer", "12121", "serebashka", "sewfwe"};
        int b=(int) (Math.RANDOM())*16;

        String bee=c[b]; */

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 5; i++){
          //  list.add(i, bee); }


        list.add(0,"eeee");
        list.add(0,"bee");
        list.add(0,"ceee");
        list.add(0,"reee");
        list.add(0,"veee"); }


        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
          //напишите тут ваш код

    }


}



