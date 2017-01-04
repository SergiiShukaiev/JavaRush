package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
  private String name;
    private double heigth;
    private String color;

    public Dog(String name){
        this.name=name;
    }//напишите тут ваш

    public Dog(String name, double heigth){
        this.name=name;
        this.heigth=heigth;
    }// код

    public Dog(String name, double heigth, String color){
        this.name=name;
        this.heigth=heigth;
        this.color=color;
    }

}
