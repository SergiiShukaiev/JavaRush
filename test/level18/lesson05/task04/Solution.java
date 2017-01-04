package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        InputStream inFile1=new FileInputStream(reader.readLine());
        OutputStream outFile2=new FileOutputStream(reader.readLine());
        while(inFile1.available()>0){
            byte[] f1=new byte[inFile1.available()];
            int date=inFile1.read(f1);
            for (int i=0; i<f1.length/2; i++){
                byte a=f1[i];
                f1[i]=f1[f1.length-i-1];
                f1[f1.length-i-1]=a;

            }
            outFile2.write(f1, 0, date);
        }

        outFile2.close();
        inFile1.close();
        reader.close();
    }
}
