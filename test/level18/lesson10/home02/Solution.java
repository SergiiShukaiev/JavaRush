package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        InputStream input=new FileInputStream(new File(args[0]));
        int countAllSymbol=0;
        int countSpace=0;
        while(input.available()>0){
            int date=input.read();
            countAllSymbol++;
            if(isSpace(date)) countSpace++;
        }
        System.out.println(Math.rint(countSpace*100.0/countAllSymbol));
        input.close();
    }
    public static boolean isSpace(int x){
        if(x==32) return true;
        else return false;
    }
}
