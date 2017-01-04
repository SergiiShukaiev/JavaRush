package com.javarush.test.level04.lesson04.task09;

/* Светофор
Работа светофора для пешеходов запрограммирована следующим образом: в начале каждого часа в течение трех минут горит зеленый сигнал,
затем в течение одной минуты — желтый, а потом в течение одной минуты — красный, затем опять зеленый горит три минуты и т. д.
Ввести с клавиатуры вещественное число t, означающее время в минутах, прошедшее с начала очередного часа.
Определить, сигнал какого цвета горит для пешеходов в этот момент.
Результат вывести на экран в следующем виде:
"зеленый" - если горит зеленый цвет, "желтый" - если горит желтый цвет, "красный" - если горит красный цвет.
Пример для числа 2.5:
зеленый
Пример для числа 3:
желтый
Пример для числа 4:
красный
Пример для числа 5:
зеленый
*/

  import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
      InputStream inputStream=System.in;
        Reader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String t=bufferedReader.readLine();
        double t1=Double.parseDouble(t);


        double c;

          c=(t1-(( Math.floor(t1 / 5)) * 5));
        if (c>=0 && c<3 || c==5)
            System.out.println("зеленый");
        else if (c>=3 && c<4)
            System.out.println("желтый");
        else if (c>=4 && c<5)
            System.out.println("красный");


    }
}