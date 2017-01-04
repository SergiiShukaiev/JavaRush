package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        File file1=new File(reader.readLine());
        File file2=new File(reader.readLine());
        BufferedReader inFile1=new BufferedReader(new FileReader(file1));
        ArrayList<Integer> list=new ArrayList<Integer>();

        String str;
        String[] strV;
        double num;

        while((str=inFile1.readLine()) !=null){
            strV=str.split(" ");
            for(String v:strV){
                num=Math.round(Double.parseDouble(v));
                list.add((int)num);
            }
        }
        BufferedWriter outFile2=new BufferedWriter(new FileWriter(file2));
        String listAll="";
        for (int a:list)
        {
            listAll = listAll + a + " ";
        }
            outFile2.write(listAll);
        outFile2.close();
        inFile1.close();
        reader.close();

    }
}
