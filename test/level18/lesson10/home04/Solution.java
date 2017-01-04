package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        File file=new File(reader.readLine());

        InputStream file11=new FileInputStream(file);
        InputStream file2=new FileInputStream(reader.readLine());
        byte[] buffer=new byte[file2.available()];
        byte[] buffer1=new byte[file11.available()];
        while(file2.available()>0){
            int count=file2.read(buffer);
        }
        while(file11.available()>0){
            int count1=file11.read(buffer1);
        }
        OutputStream file1=new FileOutputStream(file);
        byte[] res=new byte[buffer.length+buffer1.length];
        System.arraycopy(buffer, 0, res, 0, buffer.length);
        System.arraycopy(buffer1, 0, res, buffer.length, buffer1.length);

        file1.write(res);

        file11.close();
        file2.close();
        file1.close();
        reader.close();

    }
}
