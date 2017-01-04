package com.javarush.test.level04.lesson04.task07;

/* Количество дней в году
Ввести с клавиатуры год, определить количество дней в году. Результат вывести на экран в следующем виде:
"количество дней в году: x", где х - 366 для високосными года, х - 365 для обычного года.
Подсказка: В високосном году - 366 дней, тогда как в обычном  - 365.
Високосным годом является каждый четвёртый год, за исключением столетий, которые не кратны 400.
Так, годы 1700, 1800 и 1900 не являются високосными, так как они кратны 100 и не кратны 400.
Годы 1600 и 2000 — високосные, так как они кратны 100 и кратны 400.
Годы 2100, 2200 и 2300 — невисокосные.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
      InputStream inputStream=System.in;
        Reader inputStreamReader= new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String g=bufferedReader.readLine();
        int gn=Integer.parseInt(g);



     //   if (gn<100)
       // mod=(gn % 4) ;
        if ((gn%100==0) ||  (gn%4!=0))
            System.out.println("количество дней в году: " + 365);
        else
            System.out.println("количество дней в году: " + 366);

/*
        int mod1=(gn % 400);
        {if (mod1==0)
            System.out.println("Кличество дней в году: 366");
else
        { mod1=(gn % 100);
             if (mod1==0)
            System.out.println("Кличество дней в году: 365");
        else
             { mod1=(gn % 4);
        if (mod1==0)
            System.out.println("Кличество дней в году: 366");
        else
            System.out.println("Кличество дней в году: 365"); }}} */

       // int mod=((gn % 100)&(gn % 4));
      //  if (mod==0)
       //     System.out.println("Кличество дней в году: 365");





       // else
          //  System.out.println("Количество дней в году: 365");

     /*   if (gn>=100 && gn<1000)
        { int mod=gn % 40;
            if (mod==0)
                System.out.println("Количество дней в году: 366");
            else
                System.out.println("Количество дней в году: 365"); }

        if (gn>=1000)
        { int mod=gn % 400;
            if (mod==0)
                System.out.println("Количество дней в году: 366");
            else
                System.out.println("Количество дней в году: 365"); } */

      /*   int mod=gn % 100;
            if (mod==0){
                mod=gn % 400;
        if (mod==0)
            System.out.println("Количество дней в году: 366");
            else
                           System.out.println("Количество дней в году: 365");}
        else
   mod=gn % 4;
        if (mod1==0)*/

        //напишите тут ваш код

    }
}