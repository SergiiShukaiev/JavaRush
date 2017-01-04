package com.javarush.test.level07.lesson04.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }
    public static int[] initializeArray() throws IOException {
        int[] array=new int[20];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<array.length; i++){
           // String s=reader.readLine();
            array[i]=Integer.parseInt(reader.readLine());//Инициализируйте (создайте и заполните) массив тут
        }
        return array;
    }

    public static int max(int[] array)
    {
       int maximum=array[0];

        for (int i=0; i<array.length; i++){
            if (maximum<array[i])
            maximum=array[i];          //Найдите максимальное значение в этом методе
        }
        return maximum;
    }
}
