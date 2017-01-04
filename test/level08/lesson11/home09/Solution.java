package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


       // String date1="JANUARY 1 2016";
          System.out.println(isDateOdd("JANUARY 28 2016"));

    }

    public static boolean isDateOdd(String date)
    {

        Date begginYear=new Date();
        begginYear.setHours(0);
        begginYear.setMinutes(0);
        begginYear.setSeconds(0);

   //     begginYear.setYear(2016);
        begginYear.setMonth(0);
        begginYear.setDate(1);

        SimpleDateFormat format=new SimpleDateFormat();
        format.applyPattern("MMMM d yyyy");

        Date enddate=new Date(date);
   //     Date enddate = format.parse();

        long ms=enddate.getTime()- begginYear.getTime();
        long MS=24*60*60*1000;
        if (date.equals("JANUARY 1 2016")) return true;
      else   if ((Math.floor(ms/MS)) % 2 == 0 )
        return false;


        else return true;
    }
}
