package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            InputStream input = new FileInputStream(reader.readLine());
            byte[] buff = new byte[input.available()];
            int count=input.read(buff);
            if(count<1000){
                reader.close();
                input.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception{

    }
}
