package com.javarush.test.level18.lesson03.task02;

import java.io.*;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        InputStream file=new FileInputStream(new File(reader.readLine()));
        int min=128;
        while(file.available()>0){
            int date=file.read();
            if(date<min)
               min=date;
        }
        System.out.println(min);
        reader.close();
        file.close();
    }
}
