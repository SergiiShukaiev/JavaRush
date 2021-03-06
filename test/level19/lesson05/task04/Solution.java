package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader reader=new FileReader(br.readLine());
        FileWriter writer=new FileWriter(br.readLine());
        br.close();

        String text="";
        char ch=' ';
        while(reader.ready()){
            ch=(char)reader.read();
            text +=ch;
        }
        String newText=text.replaceAll("\\.","!");
        writer.write(newText);

        reader.close();
        writer.close();
    }
}
