package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        OutputStream file1=new FileOutputStream(reader.readLine());
        InputStream file2=new FileInputStream(reader.readLine());
        InputStream file3=new FileInputStream(reader.readLine());
        while(file3.available()>0)
        {
            while (file2.available() > 0)
            {
                int date = file2.read();
                file1.write(date);
            }
            int date = file3.read();
            file1.write(date);
        }
        file3.close();
        file2.close();
        file1.close();
        reader.close();
    }
}
