package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       InputStream inputStream=System.in;
        Reader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String d=bufferedReader.readLine();
        int dn=Integer.parseInt(d);

       // if ((dn<1) && (dn>7))
       // System.out.println("такого дня недели не существует");
         if (dn==1)
        System.out.println("понедельник");
        else if (dn==2)
        System.out.println("вторник");
        else if (dn==3)
            System.out.println("среда");
        else if (dn==4)
            System.out.println("четверг");
        else if (dn==5)
            System.out.println("пятница");
        else if (dn==6)
            System.out.println("суббота");
        else if (dn==7)
            System.out.println("воскресенье");
       else
           System.out.println("такого дня недели не существует");//напишите тут ваш код

    }

}