package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) {
        String fileName=args[1];
        String fileOutputName=args[2];
        try{
            FileInputStream input=new FileInputStream(fileName);
            FileOutputStream output=new FileOutputStream(fileOutputName);

            while(input.available()>0){
                int data=input.read();
                output.write(data^5);
            }
            output.close();
            input.close();
        }catch(Exception e){e.printStackTrace();}
    }
}
