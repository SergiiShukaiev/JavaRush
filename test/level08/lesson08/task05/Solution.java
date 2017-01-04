package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
       HashMap<String, String> map=new HashMap<String, String>();
        map.put("Фамилия1", "Имя1");//напишите тут ваш код
        map.put("Фамилия2", "Имя1");//напишите тут ваш код
        map.put("Фамилия3", "Имя3");//напишите тут ваш код
        map.put("Фамилия4", "Имя4");//напишите тут ваш код
        map.put("Фамилия5", "Имя5");//напишите тут ваш код
        map.put("Фамилия6", "Имя1");//напишите тут ваш код
        map.put("Фамилия7", "Имя7");//напишите тут ваш код
        map.put("Фамилия8", "Имя8");//напишите тут ваш код
        map.put("Фамилия9", "Имя9");//напишите тут ваш код
        map.put("Фамилия10", "Имя10");//напишите тут ваш код

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> map2=new HashMap<String, String>(map);
        HashMap<String, String> map3=new HashMap<String, String>(map);


            for (Map.Entry<String, String> pair: map2.entrySet()){
                map3.remove(pair.getKey());

            if (map3.containsValue(pair.getValue())) removeItemFromMapByValue(map, pair.getValue());

        }
        for (Map.Entry<String, String> m:map.entrySet())
            System.out.println(m.getKey()+" "+m.getValue());

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args){
        Solution pr=new Solution();
        pr.createMap();
        pr.removeTheFirstNameDuplicates(pr.createMap());

    }
}
