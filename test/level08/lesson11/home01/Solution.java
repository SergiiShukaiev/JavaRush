package com.javarush.test.level08.lesson11.home01;



/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution
{
 //   public static int catCount=0;
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        Iterator<Cat> it=cats.iterator();
            cats.remove(it.next());

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> set=new HashSet<Cat>();

            set.add(new Cat());
            set.add(new Cat());
            set.add(new Cat());
        //напишите тут ваш код. пункт 2
        return set;
    }

    public static void printCats(Set<Cat> cats)
    {
       for (Cat c:cats)
        System.out.println(c);

        System.out.println(cats.size());// пункт 4
    }

   public static class Cat {

   } // пункт 1
}
