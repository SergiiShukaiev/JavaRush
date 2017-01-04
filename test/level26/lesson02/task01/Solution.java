package com.javarush.test.level26.lesson02.task01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int middle=array.length/2;
        final double mediana=(array.length%2==1)?(array[middle]) : ((array[middle-1]+array[middle])/2);
        Comparator<Integer> comp=new Comparator<Integer>(){
          public int compare(Integer i1, Integer i2){
              int result=(int)Math.round(Math.abs(mediana-i1) - Math.abs(mediana-i2));
              return result==0? (i1-i2) : result;
          }
        };
        Arrays.sort(array, comp);
        //implement logic here
        return array;
    }

    public static void main(String[] args){
        Integer [] array={21,5,87,95,63,54,87,0,12,-98,101,25987,-32,-98,11};
        System.out.print(Arrays.asList(sort(array)));
    }
}
