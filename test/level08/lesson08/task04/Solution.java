package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Noris", new Date("MAY 9 1945"));
        map.put("Fegs", new Date("AUGUST 24 1991"));
        map.put("Rita", new Date("APRIL 14 1987"));
        map.put("Serejs1", new Date("FEBRUARY 02 1987"));
        map.put("Serejs2", new Date("OCTOBER 12 1983"));
        map.put("Serejs3", new Date("MARCH 08 1988"));
        map.put("Serejs4", new Date("FEBRUARY 03 1987"));
        map.put("Serejs5", new Date("FEBRUARY 04 1987"));
        map.put("Serejs6", new Date("FEBRUARY 05 1987"));

        return map;

        //напишите тут ваш код

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {

     /*   for (Map.Entry<String,Date> mo:map.entrySet()){
           long b= mo.getValue().getMonth();
            if ((b>4) && (b<8)) map.remove(mo.getKey());//напишите тут ваш код
        } */

        Iterator<Map.Entry<String, Date>> it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Date> pair=it.next();
           Date b=pair.getValue();
           // long b=pair.getValue().getMonth();
           // if (b>4 && b<8) map.remove(pair.getKey());
            if (b.getMonth()>4 && b.getMonth()<8)
                it.remove();
        }

       // System.out.println(map);

    }

    public static void main(String[] args) throws Exception{
        HashMap<String, Date> map= createMap();
        System.out.println(map);

        removeAllSummerPeople(map);
        System.out.println(map);
    }
}
