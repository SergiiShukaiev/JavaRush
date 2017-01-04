package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while(true){
            fileName=reader.readLine();
            if((fileName).equals("exit")) break;
            new ReadThread(fileName).start();
        }
        reader.close();

    }

    public static class ReadThread extends Thread
    {
        private String fileName;

        public ReadThread(String fileName) throws IOException
        {
            this.fileName = fileName;
        }

        public void run()
        {
            TreeMap<Byte, Integer> list=new TreeMap<Byte, Integer>();
            try
            {
                InputStream inFile = new FileInputStream(fileName);
            byte[] buffer = new byte[inFile.available()];
            while (inFile.available() > 0)
            {
                inFile.read(buffer);
            }
                for(byte b: buffer){
                    if (list.containsKey(b)){
                        int value=list.get(b);
                        value++;
                        list.put(b, value);
                    } else{
                        list.put(b, 1);
                    }
                }
                int max = 0;
                int byt=Byte.MIN_VALUE;
                for(Map.Entry<Byte, Integer> pair:list.entrySet()){
                    if(pair.getValue()>max){
                        max=pair.getValue();
                        byt=pair.getKey();
                    }
                }
                synchronized (resultMap){
                    resultMap.put(fileName, byt);
                }
                inFile.close();
            } catch (IOException e) {e.printStackTrace();}

        }
    }}


