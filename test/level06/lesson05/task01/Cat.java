package com.javarush.test.level06.lesson05.task01;

/* Метод finalize класса Cat
В классе Cat создать метод protected void finalize() throws Throwable
*/

public class Cat
{
    int age;
    String name;
   Cat(int age, String name){
       this.age=age;
       this.name=name;
   }
    Cat cat1=new Cat(6, "Zevs");
    Cat cat2=new Cat(3, "Roi");

    protected void finalize() throws Throwable{
        Cat cat1;
    }
    //напишите тут ваш код

}

