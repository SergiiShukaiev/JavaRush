package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
  private String name;
    private double weight;
    private int age;
    private String color;
    private String adress;

    public Cat(String name){
        this.name=name;
    }//напишите тут ваш

    public Cat(String name, double weight, int age){
        this.name=name;
        this.weight=weight;
        this.age=age;
    }// код

    public Cat(String name, int age){
        this.name=name;
        this.weight=4;
        this.age=age;
    }

    public Cat(double weight, String color){
        this.weight=weight;
        this.color=color;
        this.name=null;
        this.adress=null;
        this.age=3;
    }

    public Cat(double weight, String color, String adress){
        weight=weight;
        color=color;
        adress=adress;
    }

}
