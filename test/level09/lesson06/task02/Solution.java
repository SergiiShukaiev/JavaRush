package com.javarush.test.level09.lesson06.task02;

/* Исключение при работе со строками
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
String s = null;
String m = s.toLowerCase();
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Begin main");
       try
       { //напишите тут ваш код
           System.out.println("это будет в любом случае");

           String s = null;
           String m = s.toLowerCase();

           System.out.println("этого никогда не будет :)");
       } catch (NullPointerException ex) {
           String s=null;
           s+="";
           s+=" Описан предмет исключения:";
           s+=ex;
           s+=")))";
           System.out.println(s);

       }
        System.out.println("end main");

    }
}
