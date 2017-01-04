package com.javarush.test.level09.lesson06.task03;

/* Исключение при работе с массивами
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
int[] m = new int[2];
m[8] = 5;
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("start main");

        try
        {//напишите тут ваш код
            System.out.println("start try");
            int[] m = new int[2];
            m[8] = 5;
            System.out.println("end try");

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("start catch");
            System.out.println(ex);
            System.out.println("end catch");
            System.out.println(ex.getStackTrace());
    }
        System.out.println("end main");
    }
}
