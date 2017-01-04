package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map=new HashMap<String, Cat>();
        map.put("Mur4ik1", new Cat("Kit1"));
        map.put("Mur4ik2", new Cat("Kit2"));
        map.put("Mur4ik3", new Cat("Kit3"));
        map.put("Mur4ik4", new Cat("Kit4"));
        map.put("Mur4ik5", new Cat("Kit5"));
        map.put("Mur4ik6", new Cat("Kit6"));
        map.put("Mur4ik7", new Cat("Kit7"));
        map.put("Mur4ik8", new Cat("Kit8"));
        map.put("Mur4ik9", new Cat("Kit9"));
        map.put("Mur4ik10", new Cat("Kit10"));

        return map;
        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> catSet=new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair : map.entrySet())
        catSet.add(pair.getValue());

        return catSet;

    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
