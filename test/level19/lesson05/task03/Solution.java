package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader reader=new FileReader(br.readLine());
        FileWriter writer=new FileWriter(br.readLine());
        br.close();
        String str="";
        while(reader.ready()){
      /*   int data=reader.read();
            if (data>47 && data <58)
                writer.write(data+" "); */

           char ch=(char)reader.read();
            str=str+ch;
        }
        String[] strS=str.split(" ");
        for(String s:strS){
            if (isDigit(s)) writer.write(s+" ");
        }
        reader.close();
        writer.close();
    }
    public static boolean isDigit(String st){
        try
        {
            double a = Double.parseDouble(st);
        } catch(Exception e){return false;}
        return true;
    }
}
