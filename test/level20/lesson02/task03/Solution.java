package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties prop=new Properties();

    public void fillInPropertiesMap() throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        InputStream input=new FileInputStream(new File(reader.readLine()));
        load(input);
        reader.close();

    }

    public void save(OutputStream outputStream) throws Exception {

      //  PrintWriter writer=new PrintWriter(outputStream);
        if(prop.size()>0)
            prop.putAll(properties);
            prop.store(outputStream, "");
            // writer.close();

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        prop.load(inputStream);
        Set<String> set=prop.stringPropertyNames();
        for(String p: set)
            properties.put(p, prop.getProperty(p));
        reader.close();

    }
}
