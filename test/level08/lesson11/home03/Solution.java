package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        HashMap<String, String> map=new HashMap<String, String>();
        map.put("Ivanov1", "Ivan1");//напишите тут ваш код
        map.put("Ivanov1", "Ivan1");//напишите тут ваш код
        map.put("Ivanov3", "Ivan3");//напишите тут ваш код
        map.put("Ivanov4", "Ivan4");//напишите тут ваш код
        map.put("Ivanov5", "Ivan5");//напишите тут ваш код
        map.put("Ivanov6", "Ivan1");//напишите тут ваш код
        map.put("Ivanov7", "Ivan7");//напишите тут ваш код
        map.put("Ivanov8", "Ivan8");//напишите тут ваш код
        map.put("Ivanov9", "Ivan3");//напишите тут ваш код
        map.put("Ivanov10", "Ivan10");//напишите тут ваш код

        return map;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
