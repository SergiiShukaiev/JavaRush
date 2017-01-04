package com.javarush.test.level06.lesson08.task03;

/* Класс Util
Реализовать статический метод double getDistance(x1, y1, x2, y2). Он должен вычислять расстояние между точками.
Используй метод double Math.sqrt(double a), который вычисляет квадратный корень переданного параметра
*/

public class Util
{
    public static void main(String[] args)
    {
        Util b=new Util();

        System.out.println(b.getDistance(1,6,2,4));


    }
        public static double getDistance ( int x1, int y1, int x2, int y2)
        {
            double a = (Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
            return Math.sqrt(a);//напишите тут ваш код


    }
}
