package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        InputStream file1=new FileInputStream(reader.readLine());
        OutputStream out2=new FileOutputStream(reader.readLine());
        OutputStream out3=new FileOutputStream(reader.readLine());

        while(file1.available()>0){
            if(file1.available()%2==0){
                byte[] p1=new byte[file1.available()/2];
                byte[] p2=new byte[file1.available()/2];
                int count1=file1.read(p1);
                int count2=file1.read(p2);
                out2.write(p1, 0, count1);
                out3.write(p2, 0, count2);
            }
            else
            {
                byte[] p1 = new byte[file1.available() / 2+1];
                byte[] p2 = new byte[file1.available() / 2];
                int count1 = file1.read(p1);
                int count2 = file1.read(p2);
                out2.write(p1, 0, count1);
                out3.write(p2, 0, count2);
            }
        }
        out3.close();
        out2.close();
        file1.close();
        reader.close();

    }
}
