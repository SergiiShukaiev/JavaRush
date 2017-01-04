package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        InputStream inFile1=new FileInputStream(new File(args[0]));
        byte[] symbols=new byte[inFile1.available()];
        inFile1.read(symbols);
        Arrays.sort(symbols);
        HashMap<Byte, Integer> tabl=new HashMap<Byte, Integer>();

        int count;
        for(byte b:symbols){
            count=0;
            for(byte b1:symbols){
                if (b==b1) count++;
            }
            if(!tabl.containsKey(b))
            {
                tabl.put(b, count);
                System.out.println((char) b + " " + count);
            }
        }
        inFile1.close();
    }
}
