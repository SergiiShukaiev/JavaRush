package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Set<File> map=new TreeSet<File>();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while(!(reader.readLine()).equals("end")){
            String fileName=reader.readLine();
            File file=new File(fileName);
            map.add(file);
        }
        reader.close();
       Iterator<File> iterator=map.iterator();
            String folder= iterator.next().getAbsolutePath();
        folder = folder.substring(0, folder.length() - 6);
            FileOutputStream outFile=new FileOutputStream(folder, true);
            for(File file:map){
            FileInputStream readFile=new FileInputStream(file);
                byte[] buffer=new byte[readFile.available()];
                while(readFile.available()>0){
                    readFile.read(buffer);
                    outFile.write(buffer);
                }
                readFile.close();
        }
        outFile.close();
    }
}
