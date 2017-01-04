package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str=reader.readLine();
        String subStr=str.substring(str.indexOf("?")+1);
        String[] par=subStr.split("(\\&+)|(\\?+)");

        for(int i=0; i<par.length; i++){
            if (par[i].contains("="))
            {
                String subPar = par[i].substring(0, par[i].indexOf("="));
                System.out.print(subPar+" ");
            } else {
                System.out.print(par[i]+" ");
            }
        }

        System.out.println();

        for (int i=0; i<par.length; i++){
            if (par[i].contains("obj=")){
            String doub=par[i].substring(par[i].indexOf("=")+1);
            try{
                alert(Double.parseDouble(doub));
                } catch(NumberFormatException e) {alert(doub);}
            }
    }}


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
