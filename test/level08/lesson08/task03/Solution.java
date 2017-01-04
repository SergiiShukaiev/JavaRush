package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
  /*  public static void main(String[] args){
        Solution sol=new Solution();


        //HashMap<String, String> map=new HashMap<String, String>();
        createMap();
        getCountTheSameFirstName(createMap(),map.getKey());
        getCountTheSameLastName();
    } */

    public static HashMap<String, String> createMap()
    {
       HashMap<String, String> map=new HashMap<String,String>();
        map.put("Ivanov", "Ivan");//напишите тут ваш код
        map.put("Petrov", "Petr");//напишите тут ваш код
        map.put("Sidorov", "Sidr");//напишите тут ваш код
        map.put("Sergeev", "Sergej");//напишите тут ваш код
        map.put("Romanov", "Roman");//напишите тут ваш код
        map.put("Alexandrov", "Alexandr");//напишите тут ваш код
        map.put("Pavlov", "Pavel");//напишите тут ваш код
        map.put("Alekseev", "Aleksej");//напишите тут ваш код
        map.put("Fedorov", "Fedr");//напишите тут ваш код
        map.put("Andreev", "Andrej");

        return  map;//напишите тут ваш код
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
      int count=0;

    /*    Iterator<Map.Entry<String, String>> iterator=map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, String> pair=iterator.next();
            if (pair.getValue().contains(name)) count++;

        } */

      for (Map.Entry<String, String> p: map.entrySet()) {
      if (p.getValue().equals(name)) count++; }

     //   System.out.println(count);

        return  count;//напишите тут ваш код

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
       int count=0;
   /*     Iterator<Map.Entry<String, String>> iterator=map.entrySet().iterator();


        while (iterator.hasNext()){
            Map.Entry<String, String> pair=iterator.next();
            if (pair.getKey().contains(lastName)) count++;
        } */



        for (Map.Entry<String, String> pa : map.entrySet()){

            if (pa.getKey().equals(lastName)) count++;//напишите тут ваш код
        }
     //   System.out.println(count);

        return count;

    }
}
