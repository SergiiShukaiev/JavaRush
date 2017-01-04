package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        InputStream in=new FileInputStream(reader.readLine());
        int count=0;
        while(in.available()>0){
            int date=in.read();
            if (date==44)
                count++;
        }
        System.out.println(count);
        in.close();
        reader.close();
    }
}
