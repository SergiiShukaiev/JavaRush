package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName1=args[0];
        String fileName2=args[1];
        BufferedReader reader=new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer=new BufferedWriter(new FileWriter(fileName2));
        String line;
        StringBuilder sb=new StringBuilder();
        while((line=reader.readLine()) !=null)
        {
            String[] strL = line.split(" ");
            for (String word : strL)
            {
                if (word.length() > 6)
                    sb.append(word + ",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        writer.write(sb.toString());
            reader.close();
        writer.close();

    }
}
