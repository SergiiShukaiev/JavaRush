package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        FileReader input=new FileReader(reader.readLine());
        reader.close();
        char current=' ';
        String str="";
        int count=0;
        while(input.ready()){
            current=(char)input.read();
            str=str+current;
        }
        String replaceStr=str.replaceAll("\\p{P}"," ").toLowerCase();
        replaceStr=replaceStr.replaceAll("\\s", " ");

        String[] rS=replaceStr.split(" ");
        for(String s:rS){
           if(s.equals("world")) count++;
        }
        System.out.println(count);
        input.close();
    }
}
