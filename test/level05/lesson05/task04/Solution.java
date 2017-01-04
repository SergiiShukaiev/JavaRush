

package com.javarush.test.level05.lesson05.task04;
//import  com.javarush.test.level05.lesson05.task01.Cat;

/* Создать три объекта типа Cat
В методе main создать три объекта типа Cat и заполнить их данными.
Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
*/

public class Solution {
    public static void main(String[] args) {

     new Cat("Vaska", 4, 3, 6);
        new Cat("Barsik", 6, 5, 2);
        new Cat("Bobik", 4, 3, 1);
     //new Cat(String name, int age, int weight, int strength);
      /*  String name;
        int age;
        int weight;
        int strength; */
       //напишите тут ваш код
    }

    public static class Cat {

        public static int count = 0;
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }


    }
}
