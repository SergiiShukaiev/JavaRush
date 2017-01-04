package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        Dog snoopyDog=new Dog("Snoopy", 1200, "Gora4ij kabel");
        Dog buldogDog=new Dog("Buldog", 1500, "Silnij ha4");

        Cat tomCat= new Cat("Tom", 800, "Grey");
        Cat silvesterCat= new Cat("Silvester", 900, "Black");

        System.out.println(jerryMouse);//напишите тут ваш код
        System.out.println(snoopyDog);//напишите тут ваш код
        System.out.println(buldogDog);//напишите тут ваш код
        System.out.println(tomCat);//напишите тут ваш код
        System.out.println(silvesterCat);//напишите тут ваш код
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
        public String toString(){return name+" "+height+" "+tail;}
    }

    public static class Dog {
        String name;
        int height;
        String temp;

        public Dog(String name, int height, String temp){
            this.name=name;
            this.height=height;
            this.temp=temp;
        }
        public String toString(){return name+" "+height+" "+temp;}
         }//добавьте тут ваши классы

    public static class Cat{
        String name;
        int age;
        String color;

        public Cat(String name, int age, String color){
            this.name=name;
            this.age=age;
            this.color=color;
        }
        public String toString(){return name+" "+age+" "+color;}
    }


}
