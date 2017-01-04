package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;




/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        Integer[] array1=new Integer[array.length];
        for (int i=0; i<array.length; i++)
            array1[i]=array[i];
        Arrays.sort(array1, Collections.reverseOrder());

        for (int i=0; i<array.length; i++)
            array[i]=array1[i];



     /*   for(int k=0; k<array.length; k++)
        {
            int max = array[k];
            int max_i=k;

            for (int j=k+1; k<array.length; j++){
                if (array[j]>max) {
                    max=array[j];
                max_i=j; }
            }
            if (k!=max_i){
                int b=array[k];
                array[k]=array[max_i];
                array[max_i]=b;
            }
        } */

        return;
    }
}
