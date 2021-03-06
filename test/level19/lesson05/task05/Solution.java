package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        FileReader reader=new FileReader(br.readLine());
        FileWriter writer=new FileWriter(br.readLine());
        br.close();

        while(reader.ready()){
            char ch=(char)reader.read();
            if(!Pattern.matches("\\p{P}",String.valueOf(ch)));
            writer.write(ch);
        }
        reader.close();
        writer.close();
    }
}
