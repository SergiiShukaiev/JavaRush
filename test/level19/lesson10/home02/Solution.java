package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName=args[0];
        Map<String, Double> map=new TreeMap<String, Double>();
        BufferedReader reader=new BufferedReader(new FileReader(fileName));
        String line;
        String[] str;
        double value;

        while((line=reader.readLine()) !=null){
            str=line.split(" ");

            if(map.containsKey(str[0])){
                value=map.get(str[0]);
                map.put(str[0], value+Double.parseDouble(str[1]));
            } else
                map.put(str[0], Double.parseDouble(str[1]));
        }
        reader.close();
        double max=Double.MIN_VALUE;
        for(Map.Entry<String, Double> d:map.entrySet()){
            if(d.getValue()>=max)
                max=d.getValue();
        }
        for(Map.Entry<String, Double> pair:map.entrySet()){
            if (pair.getValue()==max)
                System.out.println(pair.getKey());
        }
    }
}
